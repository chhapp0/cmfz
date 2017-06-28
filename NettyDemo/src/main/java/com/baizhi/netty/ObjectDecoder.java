package com.baizhi.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.apache.commons.lang3.SerializationUtils;

import java.util.List;

/**
 * Created by ljf on 2017/6/28.
 */
public class ObjectDecoder extends MessageToMessageDecoder<ByteBuf>{
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        System.out.println("解码对象-----");
        //将bytebuf中的数据添加到字节组中
        byte [] bytes=new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        Object object= SerializationUtils.deserialize(bytes);
        out.add(object);
    }
}
