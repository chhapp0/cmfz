package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface CounterService {
    public void add(Counter counter);
    public void delete(String id);
    public void update(Counter counter);

    public Counter queryOne(String id);
    public List<Counter> queryAll();

}
