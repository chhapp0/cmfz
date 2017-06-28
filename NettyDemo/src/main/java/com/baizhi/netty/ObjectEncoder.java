package com.baizhi.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ljf on 2017/6/28.
 */
public class ObjectEncoder extends MessageToMessageEncoder<Object>{
    /**
     * 将对象编码 byteBuf
     * @param ctx
     * @param msg
     * @param out
     * @throws Exception
     */
    protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
        System.out.println("对象编码-----");
        byte[] bytes = SerializationUtils.serialize((Serializable) msg);
        ByteBuf buf= Unpooled.buffer();
        buf.writeBytes(bytes);
        out.add(buf);
    }
}
