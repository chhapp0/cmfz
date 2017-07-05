package com.baizhi.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created by ljf on 2017/6/28.
 */
public class ClientChannerHandlerAdapt extends ChannelHandlerAdapter {
    /**
     * 在这个方法里发消息
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       /* ByteBuf buf= Unpooled.buffer();
        buf.writeBytes("我是啥啊".getBytes());*/

       User user=new User(1,"张三");
        //写什么就发送什么
        ChannelFuture channelFuture = ctx.writeAndFlush(new Date());
        //发送消息
        //ChannelFuture channelFuture=ctx.writeAndFlush(new Date());
       // 捕获传输异常
       channelFuture.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
       // 错误退出
       channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
    }

    /**
     * 接收服务器响应
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端收到"+msg);
    }

    /**
     * 客户端异常回调
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("客户端出错了"+cause.getMessage());
    }
}
