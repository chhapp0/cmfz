package com.baizhi.service;

import com.baizhi.entity.Work;
import com.github.pagehelper.Page;

/**
 * Created by ljf on 2017/6/13.
 */
public interface WorkService {
    public void add(Work work);
    public void delete(String id);
    public void update(Work work);

    public Work queryOne(String id);
    public Page<Work> queryAll(Integer pageNum, Integer rows);
    public void deleteUser(String id);
}
