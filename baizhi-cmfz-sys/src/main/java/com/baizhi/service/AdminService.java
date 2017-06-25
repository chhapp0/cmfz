package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by ljf on 2017/6/12.
 */
public interface AdminService {
    public void add(Admin admin);

    public void update (Admin admin);

    //public void delete(String id);

    public Admin queryOne(String id);

    public Admin queryByName(Admin admin);
    public Admin queryByUserName(String username);
}
