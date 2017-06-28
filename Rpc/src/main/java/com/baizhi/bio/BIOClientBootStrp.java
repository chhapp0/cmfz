package com.baizhi.bio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by ljf on 2017/6/27.
 */
public class BIOClientBootStrp {
    public static void main(String[] args) throws IOException {
        //创建socket（响应和请求）
        Socket socket=new Socket();
        //连接服务器
        socket.connect(new InetSocketAddress("192.168.239.1",9999));
        //发送请求， 写数据， 输出流
        OutputStream outputStream=socket.getOutputStream();
        PrintWriter printWriter=new PrintWriter(outputStream);
        String msg="你好，这是客户端！";
        printWriter.println(msg);
        printWriter.flush();
        //告知服务器，请求截止
        socket.shutdownOutput();
        //读取响应 ， 读数据 输入流

        //响应
        InputStream inputStream=socket.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line=null;
        StringBuilder stringBuilder=new StringBuilder();
        while ((line=bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println("客户端收到"+stringBuilder);
        //关闭socket资源
        socket.close();
    }
}
