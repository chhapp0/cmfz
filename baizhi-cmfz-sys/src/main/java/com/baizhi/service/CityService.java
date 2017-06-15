package com.baizhi.service;

import com.baizhi.entity.City;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
public interface CityService {
 /*   public void add(City city);
    public void delete(String id);
    public void update(City city);

    public City queryOne(String id);*/
    public List<City> queryProvince(String id);
}
