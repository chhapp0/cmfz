package com.baizhi.service.impl;

import com.baizhi.entity.User;
import com.baizhi.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service("userService2")
public class UserService2 implements IUserService {
    public User queryUserById(Integer id) {
        System.out.println("调用方法。。。");
        return new User(id,"张三222",new Date());
    }

    public String queryHobies(String name) {
        System.out.println("这是爱好啊");
        return "shuijiao";
    }
}
