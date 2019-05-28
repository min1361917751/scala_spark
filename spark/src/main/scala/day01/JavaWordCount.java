package day01;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class JavaWordCount {
    public static void main(String[] args) {
        final SparkConf conf = new SparkConf().setAppName("java_wordcount").setMaster("local[*]");

        //创建sparkContext
        final JavaSparkContext jwc = new JavaSparkContext(conf);

        //获取数据
        JavaRDD<String> lines = jwc.textFile(args[0]);

        //切分
        final JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });
        //map =>tuple(word,1)
        JavaPairRDD<String, Integer> res = words
          .mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer i1, Integer i2) throws Exception {
                return i1 + i2;
            }
        }).mapToPair(new PairFunction<Tuple2<String, Integer>, Integer, String>() {
            @Override
            public Tuple2<Integer, String> call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                return stringIntegerTuple2.swap();
            }
        }).sortByKey(false)
                .mapToPair(new PairFunction<Tuple2<Integer, String>, String, Integer>() {
                    @Override
                    public Tuple2<String, Integer> call(Tuple2<Integer, String> integerStringTuple2) throws Exception {
                        return integerStringTuple2.swap();
                    }
                });

        res.saveAsTextFile(args[1]);

        //释放资源
        jwc.stop();
    }
}
