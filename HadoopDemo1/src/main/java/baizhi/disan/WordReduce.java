package baizhi.disan;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * keyIN:保证和map段输出的keyout一致""归类依据
 * valueIn:必须保证和Map段输出的valueout一直，统计的值
 *
 * Created by ljf on 2017/7/4.
 */
public class WordReduce extends Reducer<Text,IntWritable,Text,IntWritable> {
    /**
     * key:"归类依据"
     * value:对应"归类依据" 所对应的所有 “统计的值” 的集合
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int total=0;
        for (IntWritable intWritable:values){
            total+=intWritable.get();
        }
        //计算总的结果
        context.write(new Text("字符"+key.toString()+"出现了   "),new IntWritable(total));
    }
}
