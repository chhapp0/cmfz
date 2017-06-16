package com.baizhi.dao;

import com.baizhi.entity.GuruDATA;

import java.util.List;

public interface GuruMapper {
    int deleteByPrimaryKey(String id);

    int insert(GuruDATA record);

    //int insertSelective(GuruDATA record);

    GuruDATA selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(GuruDATA record);

    int updateByPrimaryKey(GuruDATA record);

    public List<GuruDATA> selectAll();


    public List<GuruDATA> selectAllAdd();


}