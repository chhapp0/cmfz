package com.baizhi.service;

import com.baizhi.entity.Essay;
import com.github.pagehelper.Page;

/**
 * Created by ljf on 2017/6/13.
 */
public interface EssayService {
    public void add(Essay essay);
    public void delete(String id);
    public void update(Essay essay);

    public Essay queryOne(String id);
    public Page<Essay> queryAll(Integer pageNum,Integer rows);
}
