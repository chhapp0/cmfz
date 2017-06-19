package com.baizhi.dao;

import com.baizhi.entity.ChapterDATA;

import java.util.List;

public interface ChapterDATAMapper {

    //删除方法
    int deleteByPrimaryKey(String id);

    //添加方法
    int insert(ChapterDATA record);

    //没用的方法
    //int insertSelective(ChapterDATA record);

    //查一个
    ChapterDATA selectByPrimaryKey(String id);

    //没用的方法
    //int updateByPrimaryKeySelective(ChapterDATA record);

    //更新
    int updateByPrimaryKey(ChapterDATA record);
//查全部
    public List<ChapterDATA> selectAll(String id);

    public void deleteAlbum(String id);
    public Integer selectMany(String id);
}