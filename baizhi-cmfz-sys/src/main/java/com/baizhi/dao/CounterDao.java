package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import com.baizhi.entity.Counter;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface CounterDao {


    public void insertCounter(Counter counter);

    public void deleteCounter(String id);

    public void updateCounter(Counter counter);

    public Counter selectOne(String id);

    public List<Counter> selectAll();

    //根据功课名称查询计数器
    public List<Counter> selectByWork(String name);

}
