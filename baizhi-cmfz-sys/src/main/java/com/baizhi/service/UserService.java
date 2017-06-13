package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface UserService {
    public void add(User user);
    public void delete(String id);
    public void update(User user);

    public User queryOne(String id);
    public List<User> queryAll();

    public User queryByName(User user
    );


}
