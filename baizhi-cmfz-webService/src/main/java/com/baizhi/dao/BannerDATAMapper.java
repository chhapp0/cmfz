package com.baizhi.dao;

import com.baizhi.entity.BannerDATA;

import java.util.List;

public interface BannerDATAMapper {
    int deleteByPrimaryKey(String id);

    int insert(BannerDATA record);

    //int insertSelective(BannerDATA record);

    BannerDATA selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(BannerDATA record);

    int updateByPrimaryKey(BannerDATA record);

    public List<BannerDATA> selectAll();
}