package com.baizhi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/29.
 */
public class TestExposeServer {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("服务启动。。。");
        System.in.read();
    }
}
