package com.baizhi.bio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by ljf on 2017/6/27.
 */
public class BIOServicerBootstrp {
    public static void main(String[] args) throws IOException {
        //server1();
        server2();
    }
    public static void server1() throws IOException {
        //创建serverSocket
        ServerSocket serverSocket = new ServerSocket();
        //绑定监听端口
        System.out.println("等待请求到来....");
        serverSocket.bind(new InetSocketAddress(9999));
        //等待请求到来，获取Socket对象（响应和请求）  blocking 阻塞方法
        Socket socket = serverSocket.accept();
        //处理Socket请求， 输入流，输出流处理，套路
        System.out.println("处理请求"+socket.getRemoteSocketAddress());
        //请求
        InputStream inputStream=socket.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line=null;
        StringBuilder stringBuilder=new StringBuilder();
        while ((line=bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println("服务器收到"+stringBuilder);
        //给出响应
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter=new PrintWriter(outputStream);
        String time="当前时间是"+new Date().toString();
        printWriter.println(time);
        printWriter.flush();
        //告知客户端数据已经截止
        socket.shutdownOutput();
        //关闭资源
        socket.close();
    }
    public static void server2() throws IOException {
        //创建serverSocket
        ServerSocket serverSocket = new ServerSocket();
        //绑定监听端口
        serverSocket.bind(new InetSocketAddress(9999));
        while (true) {
            //等待请求到来，获取Socket对象（响应和请求）  blocking 阻塞方法
            System.out.println("等待请求到来....");
            Socket socket = serverSocket.accept();
            //处理Socket请求， 输入流，输出流处理，套路
            System.out.println("处理请求" + socket.getRemoteSocketAddress());
            //请求
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println("服务器收到" + stringBuilder);
            //给出响应
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            String time = "当前时间是" + new Date().toString();
            printWriter.println(time);
            printWriter.flush();
            //告知客户端数据已经截止
            socket.shutdownOutput();
            //关闭资源
            socket.close();
        }
    }
}

