package com.baizhi.service;

import com.baizhi.entity.BannerDATA;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
public interface BannerDATAService {
    public void add(BannerDATA BannerDATA);
    public void delte(String id);
    public void update(BannerDATA BannerDATA);

    public BannerDATA queryOne(String id);
    public Page<BannerDATA> queryAll(Integer pageNum, Integer rows);

    public List<BannerDATA> queryAllAdd();
}
