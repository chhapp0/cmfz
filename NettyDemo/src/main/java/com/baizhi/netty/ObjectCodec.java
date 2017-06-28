package com.baizhi.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 进来的是 字节流，出去的是对象 图片的Out、  in
 * Created by ljf on 2017/6/28.
 */
public class ObjectCodec extends MessageToMessageCodec<ByteBuf,Object>{
    protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
        System.out.println("对象编码-----");
        byte[] bytes = SerializationUtils.serialize((Serializable) msg);
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeBytes(bytes);
        out.add(buffer);
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        System.out.println("解码对象======");
        byte[] bytes=new byte[msg.readableBytes()];
        msg.readBytes(bytes);

        Object object = SerializationUtils.deserialize(bytes);
        out.add(object);
    }
}
