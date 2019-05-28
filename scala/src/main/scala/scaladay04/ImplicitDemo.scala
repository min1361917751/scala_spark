package scaladay04

object ImplicitDemo {
  def main(args: Array[String]): Unit = {
    val a:Int = 100
    val b:Double = a
    //强制类型转换 Double => Int
    val c:Int =b.toInt
    //隐式转换方法， double =>Int
    //首先用implicit去修饰我们的方法
    //隐式转换方法的 参数是需要增强，需要扩展的类型，返回值是增强后的类型
    implicit def doubleToInt(x:Double): Int =x.toInt
    val d:Int =b
    d.times(println("a"))
  }
  //隐式转换类,通过在隐式类中去定义多个方法，去扩展隐式中非隐式参数对应的类
  implicit class IntWithTime(x:Int){
    def times[A](f: =>A)={
      def loop(x:Int):Unit ={
        if(x>0){
          f
          loop(x-1)
        }

      }
      loop(x)
    }
  }


}
