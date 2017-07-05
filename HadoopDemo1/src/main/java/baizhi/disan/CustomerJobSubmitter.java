package baizhi.disan;

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
        conf.addResource("core-site.xml");
        conf.addResource("hdfs-site.xml");
        conf.addResource("mapred-site.xml");
        conf.addResource("yarn-site.xml");

        //设置jar
        conf.set("mapreduce.job.jar","file:///E:\\BAIZHI\\fourth\\cmfz\\HadoopDemo1\\unnamed.jar");
        Job job=Job.getInstance(conf);


        //2.设置数据处理格式(读入，写出)
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        //3.设置数据路径（读入）
        Path src = new Path("/document/src");
        TextInputFormat.addInputPath(job,src);

        Path dst=new Path("/document/res11");//要求在任务提交前不存在
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
