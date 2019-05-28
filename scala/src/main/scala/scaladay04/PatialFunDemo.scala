package scaladay04

object PatialFunDemo {
  //参数的数据类型，返回值的数据类型
  //偏函数只有一个参数
  val fun1:PartialFunction[String,String] ={
    case  "spark" => "scala"
    case  "hadoop" => "java"
  }
  val fun2:PartialFunction[String,String] ={
    case  "xiu" => "xiuer"
    case  "you" => "liuyou"
  }
  def main(args: Array[String]): Unit = {
    println(fun1("spark"))
    println(fun1.apply("hadoop"))
    //判断当前的对象在偏函数实现中是否有相应的处理逻辑
    println(fun1.isDefinedAt("spark"))
    println(fun1.isDefinedAt("flink"))
    val funs = fun1.orElse(fun2)
    println(funs("spark"))
  }
}
