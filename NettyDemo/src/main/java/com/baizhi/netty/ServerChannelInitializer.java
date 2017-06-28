package com.baizhi.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;


/**
 * Created by ljf on 2017/6/28.
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel>{
    protected void initChannel(SocketChannel sc) throws Exception {
        //管道收消息。  由上往下看   解码器
        //发消息： 由下往上  编码器
        ChannelPipeline pipeline = sc.pipeline();
       //65535= 2 的 （n * 8）次方
        //数据帧，解码
        pipeline.addLast(new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
        //pipeline.addLast(new ObjectDecoder());
        pipeline.addLast(new LengthFieldPrepender(2));//消息头编码
        //编码器
        //pipeline.addLast(new ObjectEncoder());
        pipeline.addLast(new ObjectCodec());
        //最终处理
       pipeline.addLast(new ServerChannerHandlerAdapt());


    }
}
