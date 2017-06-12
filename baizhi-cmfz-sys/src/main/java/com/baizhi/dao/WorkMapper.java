package com.baizhi.dao;

import com.baizhi.entity.Work;

public interface WorkMapper {
    int deleteByPrimaryKey(String id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}