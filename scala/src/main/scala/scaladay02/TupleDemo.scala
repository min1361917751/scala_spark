package scaladay02

object TupleDemo {
  def main(args: Array[String]): Unit = {
    //构建元组
    val t1 = ("java","scala0",10)
    val  t2 = new Tuple4("scala",1,2,3)
    println(t1._1)
    println(t2._1)

    //通过下标访问,从0开始
    t1.productElement(0)

    //遍历
    for (elem <- t1.productIterator)
      println(elem)
     t1.productIterator.foreach(println)

    //拉链，对集合进行拉链操作，结果元素都是一个元组
    //zip
    val arr1 = Array("java","scala","c++")
    val arr2 = Array(1,2,3)
    val res = arr1.zip(arr2)
    res.foreach(println)
    val res2 = res.map((s:(String,Int))=> (s._1+"m",s._2) )
    res2.foreach(println)

  }

}
