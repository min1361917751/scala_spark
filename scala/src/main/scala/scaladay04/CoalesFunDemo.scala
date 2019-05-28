package scaladay04

object CoalesFunDemo {
//闭包：函数体内引用了函数外一个变量，变量和函数形成一个所谓的闭包
  val f1 = (x:Int) => x+100
  val a = 100
  val f2 = (x:Int) => x+a
}
