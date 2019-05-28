package scaladay04

object SealedClassDemo {
  //如果没有列举所有的类型，编译的时候会报一个匹配不完整的警告
  def sealedClassMatch(animal: Animal) = animal match {
    case Cat("狗贼",2) =>println("采花贼")
  }

  def main(args: Array[String]): Unit = {
    sealedClassMatch(Cat("狗贼",2))
  }
}
sealed  trait Animal
case class Cat(name:String,age:Int) extends Animal
case class Dog(name:String,age:Int) extends Animal