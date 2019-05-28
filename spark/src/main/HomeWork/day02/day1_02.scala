package day02

import org.apache.spark.{SparkConf, SparkContext}

object day1_02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("homework1").setMaster("local")
    val sc = new SparkContext(conf)
    val file = sc.textFile("J:\\西三旗千峰\\Spark\\spark02\\习题\\access.txt")
    val maps = file.map(t => {
      val split = t.split("\t")
      (split(1), 1)
    })
    val res: Array[(String, Int)] = maps.reduceByKey(_ + _).sortByKey(false).take(3)
    println(res.toBuffer)

  }
}
