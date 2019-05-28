package scaladay04

object CaseClassMatch {
  def matchDemo(person:Person)={
    person match {
      //apply 构建样例类对象
      case Person("Tom", 20) => println("狗贼")
      case Person("kate",19) => println("采花贼")
      //unplay 作对象的属性的提取
      case Person(name,age) => println(name +":"+age)
      case _ => println("match nothing")
    }

  }
  def main(args: Array[String]): Unit = {
    val tom = Person("Tom",20)
    matchDemo(tom)
  }
}
case class Person(name:String,age:Int)
