package com.baizhi.dao.none;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface UserDao {
    //增加
    public void insertUser(User user);
    //删除
    public void  deleteUser(String id);
    //修改
    public void  updateUser(User user);
    //查询
    public List<User> selectUser();
    //查一个
    public User selectOne(String id);

}
