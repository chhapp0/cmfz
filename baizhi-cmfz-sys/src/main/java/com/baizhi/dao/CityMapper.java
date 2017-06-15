package com.baizhi.dao;

import com.baizhi.entity.City;

import java.util.List;

public interface CityMapper {
 /*   int deleteByPrimaryKey(String id);

    int insert(City record);*/

    //int insertSelective(City record);

   /* City selectByPrimaryKey(String id);*/

    //int updateByPrimaryKeySelective(City record);

   /* int updateByPrimaryKey(City record);*/

    public List<City> selectProvince(String id);

    /*public List<City> selectAll();*/
}