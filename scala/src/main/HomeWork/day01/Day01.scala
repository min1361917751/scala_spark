package day01

object Day01 {
  def main(args: Array[String]): Unit = {

    //1.使用Boolean类型的控制变量跳出循环
    var jud = false
    for (i <- 1 to 10 if !jud){
      println(i)
      if(i == 5)
        jud =true
    }

    //2.编写一个for循环,计算字符串中所有字母的Unicode代码的乘积。
    //举例来说，"Hello"中所有字符串的乘积为9415087488L
    val arr = "Hello"
    var cou = 1L
    for (i <- 0 until  arr.length)
      cou = cou * arr(i)
    println(cou+"L")


    //3.编写一个函数product(s:String)，计算练习2中提到的乘积。
    val product =  (s:String) =>{
      var cou2 = 1L
      for (i <- 0 until  s.length)
        cou2 = cou2 * s(i)
      println(cou2+"L")
    }
    product("Hello")

    //4.编写一个循环，将整数数组中相邻的元素置换。
    //如，Array(1,2,3,4,5)经过置换变为Array(2,1,4,3,5)
    def arrChange(m:Array[Int]):Unit = {
      var num = 0
      for(i <- 0 until  m.length if i % 2 == 1){
        num = m(i)
        m(i) = m(i-1)
        m(i-1) = num
      }
      println(m.toBuffer)
    }
    arrChange(Array(1,2,3,4,5,6))
  }
}
