package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Banner record);

    //int insertSelective(Banner record);

    Banner selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    public List<Banner> selectAll();
}