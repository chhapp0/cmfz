package com.baizhi.service;

import com.baizhi.entity.Province;
import com.github.pagehelper.Page;

/**
 * Created by ljf on 2017/6/13.
 */
public interface ProvinceService {
    public Province queryOne(String id);
    public Page<Province> queryAll(Integer pageNum,Integer rows);
}
