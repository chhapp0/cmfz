package com.baizhi.service;

import com.baizhi.entity.Work;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface WorkService {
    public void add(Work work);
    public void delete(String id);
    public void update(Work work);

    public Work queryOne(String id);
    public List<Work> queryAll();
}
