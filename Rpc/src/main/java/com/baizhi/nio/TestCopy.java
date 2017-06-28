package com.baizhi.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by ljf on 2017/6/27.
 */
public class TestCopy {
    public static void main(String[] args) throws IOException {
      /*  //创建通道
        FileOutputStream fileOutputStream = new FileOutputStream("./Rpc/aa.txt");
        FileChannel fos=fileOutputStream.getChannel();

        FileInputStream fileInputStream = new FileInputStream("./Rpc/a.txt");
        FileChannel fis = fileInputStream.getChannel();
        //创建buffer
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        while(true){
            byteBuffer.clear();
            int r = fis.read(byteBuffer);
            if(read==-1)
            break;
            byteBuffer.flip();
            fos.write(byteBuffer);
        }
        //关闭资源
        fileInputStream.close();
        fileOutputStream.close();
        fis.close();
        fos.close();
*/
        //1.构建ByteBuffer
        ByteBuffer buffer= ByteBuffer.allocate(5);
        //写2字节
        buffer.put((byte)'a');
        buffer.put((byte)'b');
        buffer.put((byte)'c');
        buffer.put((byte)'d');
        buffer.put((byte)'e');
        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.print(buffer.get()+"　");
        }
        buffer.clear();
        System.out.println();
        buffer.put((byte)'c');
        while(buffer.hasRemaining()){
            System.out.print(buffer.get()+"===!===　"+buffer.position()+"!!"+buffer.limit());
        }
        //buffer.flip();

       /* buffer.clear();
        while(buffer.hasRemaining()){
            System.out.print(buffer.get()+"　");
        }*/

    }
}
