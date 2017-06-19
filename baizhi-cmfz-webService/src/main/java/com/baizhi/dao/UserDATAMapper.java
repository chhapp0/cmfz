package com.baizhi.dao;

import com.baizhi.entity.UserDATA;

import java.util.List;

public interface UserDATAMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserDATA record);

   // int insertSelective(UserDATA record);

    UserDATA selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(UserDATA record);

    int updateByPrimaryKey(UserDATA record);

    public List<UserDATA> selectAll();

    public UserDATA selectByUserDATAname(String phone);

    public UserDATA selectByUserDATA(String id);

    public void updateGuru(String id);

    public void updateProvince(String id);

    public void updateCity(String id);

}