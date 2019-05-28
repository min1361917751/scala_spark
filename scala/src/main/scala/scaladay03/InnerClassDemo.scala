package scaladay03

object InnerClassDemo {
  def main(args: Array[String]): Unit = {
    val outer = new Outer
    val inner = new outer.Inner
    println(outer.Inner.name1)
    println(inner.name)
  }
}
class Outer{
  class Inner{
    var name = "from inner class"
  }
  object Inner{
    var name1 = "from inner object"
  }
}
