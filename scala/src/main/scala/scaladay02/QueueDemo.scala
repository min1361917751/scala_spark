package scaladay02

object QueueDemo {
  def main(args: Array[String]): Unit = {
    //构建队列
    val q1 = scala.collection.mutable.Queue[String]()
    //尾部追加
    q1.enqueue("hh")
  }
}
