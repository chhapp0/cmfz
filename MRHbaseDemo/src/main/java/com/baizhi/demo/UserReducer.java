package com.baizhi.demo;

import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * Created by ljf on 2017/7/9.
 */
public class UserReducer extends TableReducer<Text,Text,ImmutableBytesWritable> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for(Text text:values){

        }
    }
}
