package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
public interface BannerService {
    public void add(Banner banner);
    public void delte(String id);
    public void update(Banner banner);

    public Banner queryOne(String id);
    public List<Banner> queryAll();
}
