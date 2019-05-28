package day02

object HomeWork {
  def main(args: Array[String]): Unit = {
    val res1 = List[Int](1,2,3,4,5,6,7,8,9,8,7,6,12,35,23)
    res1.map((x:Int) => x * 2).foreach(println)
    res1.filter((x:Int) => x % 2 == 0).foreach(println)
    res1.sorted.foreach(println)
    res1.sorted.reverse.foreach(println)
    val iterator: Iterator[Int] = res1.iterator
    val list: List[Int] = iterator.toList
    list.foreach(println)
    val res2 = List(List(1,3,5,7,9,11),List(2,4,6,8,10,12))
    res2.flatten.foreach(println)
    val res3 =List(List("hadoop word count"),List("spark word count"))
    res3.flatten.flatMap(_.split(" ")).foreach(println)
    res1.map((_,1)).reduce((x:(Int,Int),y:(Int,Int)) =>(x._1+x._1,y._2+y._2))
    println(res1.par.sum)
    println(res1.reduce(_+_))
    println(res1.par.reduce(_+_))





    val set1=Set(1,2,3,4,5,6,7)
    val set2=Set(3,4,5,6,9,8)
    println(set1.&(set2))
    print(set1.union(set2))
    print(set1.&~(set2))





  }
}
