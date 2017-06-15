package com.baizhi.dao;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruMapper {
    int deleteByPrimaryKey(String id);

    int insert(Guru record);

    //int insertSelective(Guru record);

    Guru selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(Guru record);

    int updateByPrimaryKey(Guru record);

    public List<Guru> selectAll();


    public List<Guru> selectAllAdd();


}