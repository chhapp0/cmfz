package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

   // int insertSelective(User record);

    User selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public List<User> selectAll();

    public User selectByUsername(String  phone);

    public void updateGuru(String id);

    public void updateProvince(String id);

    public void updateCity(String id);
}