package com.baizhi.dao;

import com.baizhi.entity.Essay;

import java.util.List;

public interface EssayMapper {
    int deleteByPrimaryKey(String id);

    int insert(Essay record);

   // int insertSelective(Essay record);

    Essay selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(Essay record);

    int updateByPrimaryKey(Essay record);

    public void deleteGuru(String id);

    public List<Essay> selectAll();

}