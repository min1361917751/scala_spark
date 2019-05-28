package day04

import java.io.{File, FileInputStream}

import scala.io.Source



object Day04_HomeWork {
  def main(args: Array[String]): Unit = {
    values(x=>x*x,-5,5)
    println(arrs(Array(1, 2, 3, 4, 53, 43, 32)))
    arr2(9)
    println(largest(x => 10 * x - x * x, 1 to 10))
  }


  //第一题
  var map:Map[Int,Int] = Map()
  def values(fun: Int =>Int, low:Int, high:Int):Unit={
    for (i <- low to high)
      map +=(i ->i*i)
    map.map(t =>{
      (t._1,t._2)
    }).toList.sortBy(_._1).foreach(println)
  }


  //第二题
  def arrs(arr:Array[Int]):Int ={
    arr.reduceLeft((x, y) => if (x > y) x else y)
  }


  //第三题
  def arr2(x:Int)={
    println((1 to x).reduceLeft(_ * _))
  }

  //第四题
  def largest(fun: Int =>Int, inputs:Seq[Int]): Int ={

    var num = 0
    for (i <- 0 until inputs.length) {
      if (num < i*10 - i * i)
        num = i*10 - i * i

    }
    num
  }

  //第五题

  def read(path:String):String = {
    Source.fromFile(new File(path)).mkString
  }

  //第六题
  implicit class readFile(f:String){
    val source = Source.fromFile(new File(f))
  }
}
