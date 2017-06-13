package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(String id);

    int insert(Chapter record);

    //int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);

    public List<Chapter> selectAll();
}