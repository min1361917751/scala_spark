package scaladay03

object NonameClassDemo {
  def main(args: Array[String]): Unit = {
    var dog = new Animal {
      override var name: String = "狗贼"

      override def skill(): Unit = println("guard")
    }
    println(dog.name)
    dog.skill()
  }
}
abstract class Animal{
  var name:String
  def skill()

}
