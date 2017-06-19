package com.baizhi.service;

import com.baizhi.entity.UserDATA;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface UserService {
    public void add(UserDATA user);
    public void delete(String id);
    public void update(UserDATA user);

    public UserDATA queryOne(String id);
    public Page<UserDATA> queryAll(Integer pageNum, Integer rows);

    public UserDATA queryByName(UserDATA user);

    public List<UserDATA> queryAllAdd();
    public UserDATA queryUser(String phone);
    public UserDATA queryUserDATA(String id);



}
