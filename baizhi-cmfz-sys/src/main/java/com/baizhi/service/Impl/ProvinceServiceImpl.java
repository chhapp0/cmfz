package com.baizhi.service.Impl;

import com.baizhi.dao.ProvinceMapper;
import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Service("provinceService")
@Transactional
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    private ProvinceMapper provinceMapper;
    public Province queryOne(String id) {
        Province province = provinceMapper.selectByPrimaryKey(id);
        return province;
    }

    public List<Province> queryAll() {
        List<Province> provinceList = provinceMapper.selectAll();
        return provinceList;
    }
}
