package com.baizhi;

import com.alibaba.dubbo.rpc.RpcContext;
import com.baizhi.entity.User;
import com.baizhi.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/6/29.
 */
public class TestClient {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("client.xml");
        IUserService userService = (IUserService) ctx.getBean("userService1");
       // IUserService userService2 = (IUserService) ctx.getBean("userService2");
      //  System.out.println(userService.getClass());
        long a = System.currentTimeMillis();
        userService.queryUserById(1);
        Future<User> userid = RpcContext.getContext().getFuture();
        userService.queryHobies("a");
        Future<String> userhobby = RpcContext.getContext().getFuture();
        User user = userid.get();
        String s = userhobby.get();
        long b = System.currentTimeMillis();
        System.out.println("耗时"+(b-a)+"===="+user+"-----"+s);
        //System.exit(0);
    }

}
