package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public interface MenuService {
    public List<Menu> queryOne();

    public List<Menu> queryTwo(String lev);

}
