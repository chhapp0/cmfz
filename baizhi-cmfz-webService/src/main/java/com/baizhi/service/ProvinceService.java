package com.baizhi.service;

import com.baizhi.entity.Province;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface ProvinceService {
    public Province queryOne(String id);
    public List<Province> queryAll();
}
