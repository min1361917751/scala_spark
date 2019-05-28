package scaladay03
//单例对象，独立对象
//类似于java中的单例对象，不能创建单例对象的对象
//单例对象中的方法，类似于java类的静态方法
object Utils {
  val count = 10
  def utilMethod()={
    println("onject method")
  }
}
object ObjectDemo{
  def main(args: Array[String]): Unit = {
    println(Utils.count)
    Utils.utilMethod()
  }
}
