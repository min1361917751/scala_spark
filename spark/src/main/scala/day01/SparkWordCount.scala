package day01

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkWordCount {
  def main(args: Array[String]): Unit = {

    //创建一个配置信息的对象
    //设置的应用程序名称、运行模式(
    // local:使用本地一个线程模拟集群执行任务
    // local[num]:使用num个线程去线程集群任务
    // local[*]:使用所有的空闲的线程去模拟集群任务
    // )
    val conf: SparkConf = new SparkConf().setAppName("scala_wordcount").setMaster("local")

    //spark上下文对象，执行spark程序的入口
    val sc:SparkContext = new SparkContext(conf)

    //读取数据源
    //通过参数设置源文件路径：hdfs文件，本地文件
    //RDD集合里的每一个元素是文件里的一行
    val lines: RDD[String] = sc.textFile(args(0))

    val stored: RDD[(String, Int)] = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _).sortBy(_._2,ascending = false)

    //结果打印，把结果从executor汇聚到driver端
    println(stored.collect().toBuffer)

    //结果保存到文件系统
    stored.saveAsTextFile(args(1))

    //资源释放
    sc.stop()
  }
}
