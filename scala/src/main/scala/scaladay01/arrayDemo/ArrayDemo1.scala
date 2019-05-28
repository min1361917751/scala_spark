package scaladay01.arrayDemo

import scala.collection.mutable.ArrayBuffer

object ArrayDemo1 {
  def main(args: Array[String]): Unit = {
    //创建定长数组：数组容量不可变
    val arr = Array(1,2,3,4,5,12,6,8,6)
    val arr2 = new Array[Int](10)
    //访问数组
    /*println(arr(0))
    arr(0) = 100
    println(arr(0))*/

    //数组的遍历
    /*for (elem <- arr)
      println(elem)
    for(i <- 0 until(arr.length))
      println(arr(i))*/
    //数组的基本方法
   /* println(arr.sum)
    println(arr.sorted.toBuffer) //顺序排序
    println(arr.sorted.reverse.toBuffer) //倒序排序
    println(arr.sortWith(_ > _).toBuffer)
    println(arr.sortWith((x: Int, y: Int) => x + 1 > y + 2).toBuffer)*/

/*    //变长数组
    val str1 = ArrayBuffer[String]()
    val str2 = new ArrayBuffer[Double]()
    str1 += "java"
    str1 += ("scala","python")
    println(str1)
    str1 ++= Array("10","20","30")
    println(str1)
    str1.append("html")
    println(str1)
    //insert，索引之前插入多个元素
    str1.insert(2,"json","xml")
    println(str1)
    //删除操作
    //从尾部删除n个元素
    str1.trimEnd(2)
    //从头部删除n个元素
    str1.trimStart(1)
    println(str1)
    str1.remove(1,2)
    println(str1)
    str1.remove(2)
    println(str1)*/
    //定义多维数组
    val matrix = Array.ofDim[Int](3,3)
    for(i <- 0 to 2;j<- 0 to 2)
      matrix(i)(j ) = i *j
    for (i <- 0 to 2)
    println(matrix(i).toBuffer)
    //定义一个不规则的数组
   /* val multiArr = new Array[Array[Int]](3)
    multiArr(0) = new Array[Int](3)
    multiArr(1) = new Array[Int](10)
    multiArr(2) = new Array[Int](20)
    println(multiArr(0).toBuffer)*/
  }
}
