package com.baizhi.service;

import com.baizhi.entity.EssayDATA;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface EssayDATAService{
    public void add(EssayDATA essay);
    public void delete(String id);
    public void update(EssayDATA essay);

    public EssayDATA queryOne(String id);
    public Page<EssayDATA> queryAll(Integer pageNum, Integer rows);

    public void deleteGuru(String id);

    public List<EssayDATA> queryAllAdd();

    public EssayDATA selectUserGuru(String id);
}
