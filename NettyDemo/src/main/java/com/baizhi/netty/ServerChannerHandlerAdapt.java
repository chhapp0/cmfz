package com.baizhi.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by ljf on 2017/6/28.
 */
public class ServerChannerHandlerAdapt extends ChannelHandlerAdapter{
    /**
     * 服务端异常捕获
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("服务器出错了"+cause.getMessage());
    }

    /**
     * 当有数据到来的时候，回调方法
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器收到"+msg);
        //写回响应
        ChannelFuture channelFuture = ctx.writeAndFlush(msg);
        //关闭Channel
        channelFuture.addListener(ChannelFutureListener.CLOSE);
    }
}
