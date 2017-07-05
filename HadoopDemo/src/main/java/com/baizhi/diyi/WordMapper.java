package com.baizhi.diyi;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by ljf on 2017/7/4.
 *
 * 对数据做简单的分析， “归类”归类依据， 按照什么归类
 *   t_char(
 *      word varchar(32),
 *      count_int
 *   )          (reduce)        (map)
 *      select sum(count) from t_char group by word;
 */
public class WordMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        /**
         * key:行记录在整个文件中的字节偏移量
         * value:前读到的一行数据
         *
         * keyout :归类依据
         * valueout：统计的值
         */
        String[] words=value.toString().split(" ");
        for (String word:words
             ) {
            System.out.println("打印的什么");
            context.write(new Text(word),new IntWritable(1));
        }
    }
}
