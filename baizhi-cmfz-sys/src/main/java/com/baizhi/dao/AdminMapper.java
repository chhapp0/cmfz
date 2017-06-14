package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminMapper {


    int deleteByPrimaryKey(String id);


    int insert(Admin record);

    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKey(Admin record);

    public  Admin selectByadminName(String adminName);
}