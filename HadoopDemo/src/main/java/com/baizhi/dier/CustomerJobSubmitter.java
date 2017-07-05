package com.baizhi.dier;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/** com.baizhi.dier.CustomerJobSubmitter
 * Created by ljf on 2017/7/4.
 */
public class CustomerJobSubmitter {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建Job
        Configuration conf=new Configuration();
        Job job=Job.getInstance(conf);

        //设置jar的加载类路径
        job.setJarByClass(CustomerJobSubmitter.class);

        //2.设置数据处理格式(读入，写出)
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        //3.设置数据路径（读入）
        Path src = new Path("file:///E:/document/src");
        TextInputFormat.addInputPath(job,src);

        Path dst=new Path("file:///E:/document/res");//要求在任务提交前不存在
        TextOutputFormat.setOutputPath(job,dst);

        //4.设置数据处理代码片段
        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReduce.class);

        //5.设置代码片段输出的key - value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(WordMapper.class);
        job.setOutputValueClass(WordReduce.class);

        //6.提交任务
        job.waitForCompletion(true);
    }
}
