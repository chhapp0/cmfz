package com.baizhi.service;

import com.baizhi.entity.GuruDATA;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface GuruService {
    public void add(GuruDATA guru);
    public void delete(String id);
    public void update(GuruDATA guru);

    public GuruDATA queryOne(String id);
    public Page<GuruDATA> queryAll(Integer pageNum, Integer rows);
    public List<GuruDATA> selectAll();
}
