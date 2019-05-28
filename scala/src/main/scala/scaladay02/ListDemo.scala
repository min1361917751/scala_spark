package scaladay02

object ListDemo {
  def main(args: Array[String]): Unit = {
    //列表的构建
    val list1 = List("a","bb","ccc")
    //空列表
    val empty = Nil
    val list2 = List()
    println(list2.getClass)
    //::,右结合
    val list3 = "a" :: "bb":: "cccc"::Nil //等价于list1
    val list4 = ("a" :: ("bb":: ("cccc"::Nil)))
    var list5 = List("a", "bb", "ccc")
    //访问列表
    println(list5(0))
    //遍历
    for (elem <- list5)
      println(elem)
    list5.foreach(println)
    list5.iterator.foreach(println)

    //列表的拆分和合并
    val List(a,b,c) = List("aa","bb","ccc")

    list5 = list5.dropWhile(_.startsWith("a"))
    list5.foreach(println)

    var list6 = List(10,20,30,4,5,6,7,7)
    list6 = list6.map((x:Int) => x+10)
    val res1 = list6.fold(0)(_+_)
    val res2 = list6.fold(0)((x:Int,y:Int) => x+y)
    val res3 = list6.reduce((x:Int,y:Int) => x+y)

    var list8 =List("abc","edf")
    //前提，集合里的元素依然是一个集合，内层集合中的元素提取出来
    val chars = list8.flatMap(_+"mm")
    chars.foreach(println)

    val list10 = List(List(1,2,3),List(4,5,6))
    val ints: List[Int] = list10.flatMap(_.reverse)
    ints.foreach(println)
    val res6 = list10.flatten
    res6.foreach(println)
  }
}
