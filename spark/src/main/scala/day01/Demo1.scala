package day01

import scala.io.Source

object Demo1 {
  def main(args: Array[String]): Unit = {
    var list1 = List[Int]()
    for( i <- 1 to 100)
      list1 = i :: list1
    val list2: List[Int] = list1.filter(_  % 2 == 0)
    println(list2)

    val arr ="aaa,bbb,ccc"
    val array: Array[String] = arr.split(",").toArray
    println(array.toBuffer)
    val file = Source.fromFile("C:\\Users\\min\\Desktop\\运营项目指标计算.txt").mkString
    file.split(" ").toList.map((_,1)).groupBy(_._1).mapValues(_.size).foreach(println)
  }

}
