package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterMapper {

    //删除方法
    int deleteByPrimaryKey(String id);

    //添加方法
    int insert(Chapter record);

    //没用的方法
    //int insertSelective(Chapter record);

    //查一个
    Chapter selectByPrimaryKey(String id);

    //没用的方法
    //int updateByPrimaryKeySelective(Chapter record);

    //更新
    int updateByPrimaryKey(Chapter record);
//查全部
    public List<Chapter> selectAll();

    public void deleteAlbum(String id);
}