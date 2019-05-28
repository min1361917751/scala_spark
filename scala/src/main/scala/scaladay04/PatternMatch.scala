package scaladay04

object PatternMatch {
  def main(args: Array[String]): Unit = {
    //多变量定义
    val (a,b,c,d) =("string",true,100,120)
    //map遍历
    val map = Map("scala" -> 1,"hadoop" ->2)
    for ((k,v) <-map)
      println(k +":"+v)
    //
    for ((arc,"scala")<-Set("spark" -> "scala","hadoop" ->"java"))
      println(arc)
  }
}
