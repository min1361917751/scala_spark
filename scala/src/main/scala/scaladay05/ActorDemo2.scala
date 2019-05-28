package scaladay05

import scala.actors.Actor

object ActorDemo2 {
  def main(args: Array[String]): Unit = {
    val actor = new Actor3
    actor.start()
    actor ! "start"
    actor ! "stop"
  }
}
class Actor3 extends Actor{
  override def act(): Unit = {
    while (true)
      receive{
        case "start" =>
          println("starting")
          Thread.sleep(1000)
          println("started")
        case "stop" =>
          println("stoping")
          Thread.sleep(1000)
          println("stoped")
      }

  }
}
class Actor4 extends Actor{
  override def act(): Unit = {
    loop{
      //可以进行线程的复用
      react{
        case "start" =>
          println("starting")
          Thread.sleep(1000)
          println("started")
        case "stop" =>
          println("stoping")
          Thread.sleep(1000)
          println("stoped")
      }
    }
  }
}