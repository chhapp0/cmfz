package com.baizhi.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by ljf on 2017/6/27.
 */
public class NIOClientBootStrp {
    public static void main(String[] args) {
        String msg=sendMsg("这是什么啊a");
        System.out.println(msg);
    }
    public static String sendMsg(String msg){
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        try {
            //创建Socket 响应和请求
            SocketChannel socketChannel=SocketChannel.open();
            //连接服务器 ip，port
            socketChannel.connect(new InetSocketAddress("192.168.239.1",9999));
            //发送请求 写数据，输出流
            ByteBuffer byteBuffer=ByteBuffer.wrap(msg.getBytes());
            //发请求
            socketChannel.write(byteBuffer);
            socketChannel.socket().shutdownOutput();
            //读取响应， 读数据，输入流
            while (true){
                byteBuffer.clear();
                int read = socketChannel.read(byteBuffer);
                if(read==-1) break;
                byteBuffer.flip();
                baos.write(byteBuffer.array(),0,read);
            }
            //关闭socket资源
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(baos.toByteArray());
    }
}
