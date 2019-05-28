package scaladay02

import scala.collection.mutable.ListBuffer

object ListDemo2 {
  def main(args: Array[String]): Unit = {
    val list1 = ListBuffer[String]()
    list1 += "scala"
    list1.append("spark","flink")
    list1 ++= List("a")
  }
}
