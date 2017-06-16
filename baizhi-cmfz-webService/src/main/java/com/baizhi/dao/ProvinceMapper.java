package com.baizhi.dao;

import com.baizhi.entity.Province;

import java.util.List;

public interface ProvinceMapper {

    Province selectByPrimaryKey(String id);


    public List<Province> selectAll();
}