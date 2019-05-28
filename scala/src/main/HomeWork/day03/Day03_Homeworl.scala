package day03

object Day03_Homeworl {
  def main(args: Array[String]): Unit = {

    val person = new Person("王 二")
    println(person.lastName)
    println(person.firstName)
    println(Point(3, 4))


    val list:List[Int]=List(1,2,3)
    list match {
      case 1:: Nil => print("以1开头")
      case x::2::y::Nil => print("List含有三个元素，并且第二个元素是2")
      case x::3::Nil=>print("List含有两个元素，并且最后一个元素是3")
      case _ =>println("fail");
    }
  }

}


class Person (var name:String){
  private val str: Array[String] = name.split(" ")
  val firstName = str(0)
  val lastName = str(1)
}
class Point{
  var grade:Int = 0
  var age:Int = 0

  override def toString: String = grade+","+ age

}
object Point{
  def apply(grade:Int,age:Int): Point = {
    val point = new Point
    point.age = age
    point.grade =grade
    point
  }

}
abstract class Shape{
  var name:String
  val age:Int = 20
  def centerPoint(): Unit ={
    println("你好")
  }
}
class Rectangle(var birth:String) extends Shape {

  var name: String = "张三"
  var bir = birth
  override val age: Int = 21
  override  def centerPoint(): Unit = {
    println("hello word")
  }
}
class Circle(var sex:String) extends Shape{

  this.sex = "男"
  var name: String = "李四"
  override val age: Int = 28
  override  def centerPoint(): Unit = {
    println("hello spark")
  }

}
