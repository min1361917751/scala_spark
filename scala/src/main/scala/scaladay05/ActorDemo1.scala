package scaladay05

import scala.actors.Actor

//创建actor
object ActorDemo1 {
  def main(args: Array[String]): Unit = {
    actor1.start()

  }
}
object actor1 extends  Actor{
  override def act(): Unit = {
    for (i <- 1 to 10)
      println("acotr1:" + i)
    Thread.sleep(1000)
  }
  object actor2 extends Actor{
    override def act(): Unit = {
      for (i <- 1 to 10)
        println("acotr2:" + i)
      Thread.sleep(1000)
    }
  }
}