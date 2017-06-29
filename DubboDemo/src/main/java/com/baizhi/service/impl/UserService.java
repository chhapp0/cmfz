package com.baizhi.service.impl;

import com.baizhi.entity.User;
import com.baizhi.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service("userService1")
public class UserService implements IUserService {
    public User queryUserById(Integer id) {
        System.out.println("调用方法。。。");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User(id,"张三",new Date());
    }

    public String queryHobies(String name) {
        System.out.println("asdsad");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "睡觉";
    }
}
