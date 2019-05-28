package scaladay02

import scala.collection.immutable.HashSet

object SetDemo {
  def main(args: Array[String]): Unit = {
    var set1 = new HashSet[String]()
    set1 = set1 +"ss"
    set1 = set1 ++ Set("ss","sd","sf")
    println(set1)

    //构建可变的set
    val set2 = scala.collection.mutable.HashSet[Int]()
    set2 += 10
    set2 += 30

  }

}
