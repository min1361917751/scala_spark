package scaladay02

object MapDemo1 {
  def main(args: Array[String]): Unit = {
    //map构建
    //scala的键值对
    val map1 = Map("tom" -> 20,"jerry" ->18)
    //通过元组形式
    val map2 = Map(("tom",20),("jerry",18))
    //构建可变map
    val map3 = scala.collection.mutable.Map(("tom",20),("jerry",18))

    /*//1.map 访问
    if (map2.contains("tom"))
      println(map2("tom"))

    //2.getOrElse
    println(map2.getOrElse("tom2", 0))

    //4.如果存在，返回some，如果不存在返回None
    println(map2.get("tom"))
    println(map2.get("tom").get) //如果值不存在不能get，否则会报错*/

    //修改：添加和删除
    //如果键存在，则修改，不存在就添加
    map3("marry") = 20
    map3("tom") = 25
    map3.update("kate",18)
    map3.update("tom",10)
    map3 +=("tim" -> 20)
    map3 ++=map2
    for (elem <- map3)
      println(elem)
    for ((k,v) <- map3)
      println((k + ":" + v))
    for(k <- map3.keySet)
      println(k + "=" +map3(k))

    val hashmap = scala.collection.mutable.HashMap("tom" ->20,"jerry" ->18)
    println(hashmap.getOrElse("tom", 0))
    println(hashmap.getClass)
    println(hashmap.put("tom", 23))
    println(hashmap += (("tom2", 23)))
    hashmap.drop(1)
    hashmap.foreach(println)

  }

}
