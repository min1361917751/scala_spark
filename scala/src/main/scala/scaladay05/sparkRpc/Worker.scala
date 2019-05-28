package scaladay05.sparkRpc


import java.util.UUID

import akka.actor.{Actor, ActorSelection}



class Worker(masterUrl:String) extends Actor{
  var masterProxy:ActorSelection = _
  val workid = UUID.randomUUID().toString

  override def preStart(): Unit = {
    //从上下文获取master代理
    masterProxy = context.actorSelection(masterUrl)

  }
  override def receive: Receive = {
    case "started" =>
      //向master发送注册的消息

  }

}
