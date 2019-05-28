package day04

import scala.actors.{Actor, Future}
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object HomeWork_FirstWeek {
  def main(args: Array[String]): Unit = {
    val files = Array("C://a.txt","C://b.txt","C://c.txt")
    readFile(files)
  }
  def readFile(files:Array[String]): Unit ={
    val arr = new ArrayBuffer[Future[Any]]()
    val map = new ArrayBuffer[Map[String,Int]]()
    for (file <- files){
      val task = new Task
      task.start()
      val reply = task !! SubmitTask(file)
      arr += reply
    }
    while (arr.nonEmpty){
      val buffer: ArrayBuffer[Future[Any]] = arr.filter(_.isSet)
      for (buf <- buffer){
        val stringToInt: Map[String, Int] = buf.apply().asInstanceOf[Map[String,Int]]
        map += stringToInt
        arr -= buf
      }
    }
    val values = map.flatten.groupBy(_._1).mapValues(_.reduce((x, y) => (x._1, x._2 + y._2))).values
    println(values)
  }
}
class Task extends Actor{
  override def act():Unit = {
    while (true)
      receive{
        case SubmitTask(file) => {
          val linesIt: Iterator[String] = Source.fromFile(file).getLines()
          val lines: List[String] = linesIt.toList
          val words: List[String] = lines.flatMap(_.split(" "))
          val tuples: List[(String, Int)] = words.map((_, 1))
          val grouped: Map[String, List[(String, Int)]] = tuples.groupBy(_._1)
          val sumed: Map[String, Int] = grouped.mapValues(_.size)
          sender ! sumed
        }
      }
  }
}
case class SubmitTask(file:String)