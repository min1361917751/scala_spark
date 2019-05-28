package scaladay01.forDemo

object FunDemo {
  def add (x:Int,y:Int) = x+y
  //参数列表的形式（柯里化）
  def add1(x:Int)(y:Int) = x+y
  //带有默认参数的方法
  def add3 (mesg:String="scala") = println(mesg)
  def add4 (x:Int = 2,y:Int = 3,z:Int) = x+y+z
  //可变长参数
  def add5(x:Int*): Unit ={

    for (i <- x)
      println(i)
  }
  def main(args: Array[String]): Unit = {
    println(add(2,3))
    println(add1(2)(3))
    add3()
    add3("spark")
    println(add4(z = 10))
    println(add4(10,20, z = 30))
    add5(10,20,30 ,40 ,50)
  }
}
