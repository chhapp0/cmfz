package com.baizhi.service;

import com.baizhi.entity.Guru;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface GuruService {
    public void add(Guru guru);
    public void delete(String id);
    public void update(Guru guru);

    public Guru queryOne(String id);
    public Page<Guru> queryAll(Integer pageNum,Integer rows);
    public List<Guru> selectAll();
}
