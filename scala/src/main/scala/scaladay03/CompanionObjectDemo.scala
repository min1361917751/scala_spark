package scaladay03

//Student对象的伴生类
class Student{
  var name = "麻架构"
  private val age = 20
  private [this] val gender = "female"
}

//类Student的伴生对象
//定义同一个源文件
//单例对象的名字和类名一致，单例对象成为相应类的伴生对象
object Student{
  var objectName = "from object"
  def getMsg()={

  }

  def main(args: Array[String]): Unit = {
    val student = new Student
    student.name
    student.age
  }
}
object CompanionObjectDemo {
  def main(args: Array[String]): Unit = {

  }
}
