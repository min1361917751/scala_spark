package day02

import org.apache.spark.{SparkConf, SparkContext}

object day_02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("homework").setMaster("local")
    val sc = new SparkContext(conf)
    val list =  sc.parallelize(List(
      (12,"张三",25,"男","chinese",50),
      (12,"张三",25,"男","math",60),
      (12,"张三",25,"男","english",70),
      (12,"李四",20,"男","chinese",50),
      (12,"李四",20,"男","math",50),
      (12,"李四",20,"男","english",50),
      (12,"王芳",19,"女","chinese",70),
      (12,"王芳",19,"女","math",70),
      (12,"王芳",19,"女","english",70),
      (13,"张大三",25,"男","chinese",60),
      (13,"张大三",25,"男","math",60),
      (13,"张大三",25,"男","english",70),
      (13,"李大四",20,"男","chinese",50),
      (13,"李大四",20,"男","math",60),
      (13,"李大四",20,"男","english",50),
      (13,"王小芳",19,"女","chinese",70),
      (13,"王小芳",19,"女","math",80),
      (13,"王小芳",19,"女","english",70))
    )
    //一共有多少人参加考试
    val num = list.map(_._2).collect().distinct.toBuffer.size
    println("一共有"+num+"人参加考试")

    //一共有多少个小于20岁的人参加考试
    val num2 = list.filter(_._3 > 20).map(_._2).distinct().collect().toBuffer.size
    println("一共有"+num2+"个小于20岁的人参加考试")

    //一共有多少个等于20岁的人参加考试
    val num3= list.filter(_._3 > 20).map(_._2).distinct().collect().toBuffer.size
    println("一共有"+num3+"个等于20岁的人参加考试")

    //一共有多少个大于20岁的人参加考试
    val num4 = list.filter(_._3 > 20).map(_._2).distinct().collect().toBuffer.size
    println("一共有"+num4+"个大于20岁的人参加考试")

    //一共有多个男生参加考试
    val numM = list.filter(_._4.equals("男")).map(_._2).distinct().collect().toBuffer.size
    println("一共有"+numM+"个男生参加考试")

    //一共有多个女生参加考试
    val numW = list.filter(_._4.equals("女")).map(_._2).distinct().collect().toBuffer.size
    println("一共有"+numW+"个男生参加考试")

    //12班有多少人参加考试
  }
}
