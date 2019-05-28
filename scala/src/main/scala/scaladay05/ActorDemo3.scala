package scaladay05

import scala.actors.{Actor, Future}

object ActorDemo3 {
  def main(args: Array[String]): Unit = {
  val actor = Actor5.start()
    //发送异步消息,没有返回值
    actor !AsyncMsg(1,"Async and no reply message")
    //发送同步消息
    val reply: Any = actor !?SyncMsg(2,"Sync and reply message")
    println(reply)
    //发送异步有返回值的消息
    val async: Future[Any] = actor !! AsyncMsg(3,"Async and reply message")
    //isSet判断对方是否已经回消息
    Thread.sleep(1000) //消息发出去之后不管了，如果不等待1s，结果可能是"no reply"
    if(async.isSet) {
      val value = async.apply()
      println(value)
    }else{
      println("no reply")
    }


  }
}
object Actor5 extends Actor{
  override def act(): Unit = {
    while (true)
      receive{
        case AsyncMsg(id,msg) =>
          println(id+":"+msg)
          sender !ReplyMsg(id,"success")
        case SyncMsg(id,msg) =>
          println(id+":"+msg)
          sender !ReplyMsg(id,"success")
      }
  }
}
case class AsyncMsg(id:Int,msg:String)
case class SyncMsg(id:Int,msg:String)

case class ReplyMsg(id:Int,msg:String)