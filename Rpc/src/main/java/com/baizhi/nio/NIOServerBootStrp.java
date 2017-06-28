package com.baizhi.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by ljf on 2017/6/27.
 */
public class NIOServerBootStrp {
    public static void main(String[] args) throws IOException {
        testServer1();
      //  hasRemaining()   判断当前位置是否在限制范围内，告知程序在当前位置和限制之间是否有元素，是否继续往下读取数据。
    }

    public static void testServer1() throws IOException {
        //       创建ServerSocketChannel,  可以设置非阻塞通信  新建NIO通道
        ServerSocketChannel serversChannel = ServerSocketChannel.open();
        //     绑定监听端口  ServerSocketChannel.socket====ServerSocket
        //     ServerSocketChannel ======ServerSocket的替代类, 支持阻塞通信与非阻塞通信。
        //    创建基于NIO通道的ServerSocket连接, 新建ServerSocket通道的端口  相当于学校请老师
        serversChannel.socket().bind(new InetSocketAddress(9999));
        //设置通道非阻塞
        serversChannel.configureBlocking(false);
        //创建通道选择器
        Selector selector = Selector.open();
        //注册op_accept，准备好接受客户端的连接
        serversChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
  //select方法返回的int值表示有多少通道已经就绪,自上次调用select方法后有多少通道编程就绪状态，如果调用select方法，有一个通道变成就绪状态，返回了1，若再次调用select方法，如果另一个通道就绪，会再次返回1
            //获取通道内是否有选择器的关心事件, 意思是有多少学生报告
            System.out.println("我开始监听");
            int select = selector.select();
            if(select>=1){
                //索取所有事件的keys  通过调用selector的selectorKeys()方法，访问”已选择键集“中的就绪通道，遍历这个已选择的集合来访问就绪的通道
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //hasnext()从第一个判断， 为true
                while (iterator.hasNext()){
                    //拿到当前请求通道的值
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        //获取通道
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        //转换监听和客户端的通信.
                        SocketChannel serversChannel1 = channel.accept();
                        //设置非阻塞
                        serversChannel1.configureBlocking(false);
                        //注册读事件
                        serversChannel1.register(selector,SelectionKey.OP_READ);
                    }else if (key.isReadable()){
                        //返回创建此键的通道，接受客户端建立连接的请求，并返回 SocketChannel 对象
                        SocketChannel serversChannel1= (SocketChannel) key.channel();
                        ByteArrayOutputStream baos=new ByteArrayOutputStream();
                        ByteBuffer buffer= ByteBuffer.allocate(1024);
                        while (true){
                            buffer.clear();
                            int read = serversChannel1.read(buffer);
                            if(read==-1) break;
                            buffer.flip();
                            baos.write(buffer.array(),0,read);
                        }
                        //无需设置非阻塞，直接注册
                        //从客户端请求拿过来的schannel。 已经设置false.不要在设置
                        serversChannel1.register(selector,SelectionKey.OP_WRITE);
                    }else if(key.isWritable()){
                        //返回创建此键的通道，接受客户端建立连接的请求，并返回 SocketChannel 对象
                        SocketChannel serversChannel2 = (SocketChannel) key.channel();
                        String msg="系统时间"+new Date().toString();
                        ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                        serversChannel2.write(wrap);
                        //告知客户端写截止
                        serversChannel2.socket().shutdownOutput();
                        serversChannel2.close();
                    }
                    //移除事件
                    iterator.remove();
                }
            }else {
                continue;
            }
        }
    }
}
