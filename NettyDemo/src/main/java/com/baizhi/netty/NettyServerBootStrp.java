package com.baizhi.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by ljf on 2017/6/28.
 */
public class NettyServerBootStrp {
    public static void main(String[] args) throws InterruptedException {
        //1.创建Netty服务端启动引导
        ServerBootstrap sbt = new ServerBootstrap();
        //2 创建Netty工作线程池
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        //3 设置线程池
        sbt.group(boss,worker);
        //4 设置底层NIO请求接受实现类
        sbt.channel(NioServerSocketChannel.class);
        //5 初始化通讯管道  极其重要
        sbt.childHandler(new ServerChannelInitializer());
        System.out.println("我在9999监听-----");

        //6  绑定监听端口并启动服务
        ChannelFuture channelFuture = sbt.bind(9999).sync();
        //7。 关闭服务
        channelFuture.channel().closeFuture().sync();
        // 8。 释放线程池资源
        boss.shutdownGracefully();
        worker.shutdownGracefully();
    }
}
