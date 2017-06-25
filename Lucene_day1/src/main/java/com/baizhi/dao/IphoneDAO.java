package com.baizhi.dao;

import com.baizhi.entity.Iphone;

import java.util.List;

/**
 * Created by ljf on 2017/6/22.
 */
public interface IphoneDAO {
    public void insert(Iphone iphone);

    public Iphone selectOne(String id);

    public Iphone selectHref(String href);

    public List<Iphone> selectAll();

    public void update(Iphone iphone);

    public void delete(String id);
}
