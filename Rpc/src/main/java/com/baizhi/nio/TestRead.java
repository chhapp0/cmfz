package com.baizhi.nio;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * Created by ljf on 2017/6/27.
 */
public class TestRead {
    public static void main(String[] args) throws IOException {
        //创建通道
        FileInputStream fileInputStream = new FileInputStream("./Rpc/a.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        //内存变量。 普通IO对应磁盘， bao、bio 对应内存
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        while(true){
            //每次读数据，应该先clear，不然 pos --limit 为0,不能添加
            byteBuffer.clear();
            //从buffer拿数据
            int read = channel.read(byteBuffer);
            if(read==-1) break;
            //获取数据，应该先flip
            byteBuffer.flip();
            byteArrayOutputStream.write(byteBuffer.array(),0,read);
        }
        String content=new String(byteArrayOutputStream.toByteArray());
        System.out.println(content);
        //关闭资源
        channel.close();
        fileInputStream.close();
    }
}
