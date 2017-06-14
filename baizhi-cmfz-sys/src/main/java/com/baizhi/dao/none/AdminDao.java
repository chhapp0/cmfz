package com.baizhi.dao.none;

import com.baizhi.entity.Admin;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface AdminDao {

    public void insertAdmin(Admin admin);

    public void updateAdmin(Admin admin);

    public Admin selectOne(String id);

}
