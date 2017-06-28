package com.baizhi.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * Created by ljf on 2017/6/27.
 */
public class TestWrite {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./Rpc/a.txt");
        //获取通道
        FileChannel fileChannel=fileOutputStream.getChannel();
        String msg="快来学习JAVA";
        ByteBuffer byteBuffer=ByteBuffer.allocate(msg.getBytes().length);
        byteBuffer.put(msg.getBytes());
        //写数据到磁盘， 读buffer
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        //关闭资源
        fileChannel.close();
        fileOutputStream.close();
    }
}
