package scaladay01.forDemo

object Demo1 {
  def main(args: Array[String]): Unit = {
    /*for(i <- 1 to 10)
      println(i)
    for (i <- Array(10,20,30))
      println(i)*/
    /*for (j <- 10 until (20))
      println(j)*/
    /*for (j <- 10 until(20) by 2)
      println(j)*/
    /*for (i <- 1 to 10 by 2;j <- 1 to 10 by 2)
      println(i*10 + j)*/
    //for推导，通过yield，基于一个旧的集合，去构建一个新的集合
    val res = for(i <- Array(1,2,3,4,5))yield i+"1"
    println(res.toBuffer)
  }
}
