package com.baizhi.service.Impl;

import com.baizhi.dao.MenuMapper;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> queryOne() {
        List<Menu> menuList = menuMapper.selectOne();
        return menuList;
    }

    public List<Menu> queryTwo(String lev) {
        List<Menu> menuList = menuMapper.selectTwo(lev);
        return menuList;
    }
}
