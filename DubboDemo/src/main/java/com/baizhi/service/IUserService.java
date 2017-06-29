package com.baizhi.service;
import com.baizhi.entity.User;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface IUserService {
    public User queryUserById(Integer id);
    public String queryHobies(String name);
}
