package scaladay02

object WordCount {
  def main(args: Array[String]): Unit = {
    val lines = List(
      "Sign up for your own profile on GitHub, the best place to host code, manage projects, and build software alongside 36 million developers",
      "Your team can create review processes that improve the quality of your code and fit neatly into your workflow",
      "Pull requests are fundamental to how teams review and improve code on GitHub")
    /*val words = lines.flatMap(_.split(" ")).map((_,1)).groupBy(_._1).mapValues(_.size).toList.sortWith(_._2 > _._2)
    words.foreach(println)*/
    lines.flatMap(_.split(" ")).groupBy(_.toString).mapValues(_.size).toList.sortBy(-_._2).foreach(println)

  }
}
