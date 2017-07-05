package com.baizhi.diyi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/** com.baizhi.dier.CustomerJobSubmitter
 *
 * MapReduce 角色
 •Client ：作业提交发起者。
 •JobTracker: 初始化作业，分配作业，与TaskTracker通信，协调整个作业。
 •TaskTracker：保持与JobTracker的通信，在分配的数据片段上执行Map或Reduce任务，TaskTracker和JobTracker的不同有个很重要的方面，就是在执行任务时候TaskTracker可以有n多个，JobTracker则只会有一个（JobTracker只能有一个就和hdfs里namenode一样存在单点故障，我会在后面的mapreduce的相关问题里讲到这个问题的）

 Hdfs：保存作业的数据、配置信息等等，最后的结果也是保存在hdfs上面
 *
 * Created by ljf on 2017/7/4.
 */
public class CustomerJobSubmitter {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1.创建Job ，初始化Configuration。读取mapreduce系统配置信息，包括hdfs和mapreduce。 xx.xml配置文件等信息
        Configuration conf=new Configuration();

        Job job=Job.getInstance(conf);

        //设置jar的加载类路径
        job.setJarByClass(CustomerJobSubmitter.class);


        //2.设置数据处理格式(读入，写出)
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        //3.设置数据路径（读入）
        Path src = new Path("/document/src");
        TextInputFormat.addInputPath(job,src);

        Path dst=new Path("/document/res");//要求在任务提交前不存在
        TextOutputFormat.setOutputPath(job,dst);

        //4.设置数据处理代码片段
        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReduce.class);

        //5.设置代码片段输出的key - value类型   定义输出的key/value的类型，也就是最终存储在hdfs上结果文件的key/value的类型。
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(WordMapper.class);
        job.setOutputValueClass(WordReduce.class);

        //6.提交任务
        job.waitForCompletion(true);


    }
}
