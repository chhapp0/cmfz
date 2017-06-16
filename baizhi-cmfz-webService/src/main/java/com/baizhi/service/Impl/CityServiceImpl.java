package com.baizhi.service.Impl;

import com.baizhi.dao.CityMapper;
import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/15.
 */
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{
    @Autowired
    private CityMapper cityMapper;

    public List<City> queryProvince(String id) {
        List<City> cityList = cityMapper.selectProvince(id);
        return cityList;
    }
   /* public void add(City city) {

    }

    public void delete(String id) {

    }

    public void update(City city) {

    }

    public City queryOne(String id) {
        return null;
    }

    public List<City> queryAll() {
        List<City> cityList = cityMapper.selectAll();
        return cityList;
    }*/
}
