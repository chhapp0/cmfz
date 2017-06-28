package com.baizhi.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by ljf on 2017/6/28.
 */
public class NettyClientBoosStrp {
    public static void main(String[] args) throws InterruptedException {
        //1.创建Netty服务端启动引导
        Bootstrap bt = new Bootstrap();
        //2 创建Netty工作线程池
        NioEventLoopGroup worker = new NioEventLoopGroup();
        //3 设置线程池
        bt.group(worker);
        //4 设置底层NIO请求接受实现类
        bt.channel(NioSocketChannel.class);
        //5 初始化通讯管道  极其重要
        bt.handler(new ClientChannelInitalizer());
        //6  绑定监听端口并启动服务
        ChannelFuture channelFuture = bt.connect("192.168.0.13",9999).sync();
        //7。 关闭服务
        channelFuture.channel().closeFuture().sync();
        // 8。 释放线程池资源
        worker.shutdownGracefully();
    }
    }
