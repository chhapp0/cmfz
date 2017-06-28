package com.baizhi.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * Created by ljf on 2017/6/28.
 */
public class ClientChannelInitalizer extends ChannelInitializer<SocketChannel>{
    protected void initChannel(SocketChannel sc) throws Exception {
        ChannelPipeline pipeline=sc.pipeline();
        //数据帧，解码
        pipeline.addLast(new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
       // pipeline.addLast(new ObjectDecoder());
        //消息头编码
        pipeline.addLast(new LengthFieldPrepender(2));
        //编码器
        //pipeline.addLast(new ObjectEncoder());
        pipeline.addLast(new ObjectCodec());
        pipeline.addLast(new ClientChannerHandlerAdapt());
    }
}
