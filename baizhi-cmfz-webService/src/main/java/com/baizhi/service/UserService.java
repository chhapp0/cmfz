package com.baizhi.service;

import com.baizhi.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface UserService {
    public void add(User user);
    public void delete(String id);
    public void update(User user);

    public User queryOne(String id);
    public Page<User> queryAll(Integer pageNum, Integer rows);

    public User queryByName(User user);

    public List<User> queryAllAdd();
}
