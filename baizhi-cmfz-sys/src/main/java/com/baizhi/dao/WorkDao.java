package com.baizhi.dao;

import com.baizhi.entity.Work;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface WorkDao {

    public void insertWork(Work work);

    public void deleteWork(String id);

    public void updateWork(Work work);

    public Work selectOne(String id);

    public List<Work> selectAll();

    //根据用户名查询
    public List<Work> selectByUser(String name);


}
