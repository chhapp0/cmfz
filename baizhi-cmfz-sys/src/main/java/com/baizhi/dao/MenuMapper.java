package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuMapper {

    //int deleteByPrimaryKey(String id);

    public List<Menu> selectOne();
    //int insert(Admin record);

    //Admin selectByPrimaryKey(String id);

    //int updateByPrimaryKey(Admin record);
    public List<Menu> selectTwo(String lev);
}