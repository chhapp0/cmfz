package com.baizhi.dao.none;

import com.baizhi.entity.Guru;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface GuruDao {

    public void insertGuru(Guru guru);

    public void deleteGuru(String id);

    public void updateGuru(Guru guru);

    public Guru selectOne(String id);

    public List<Guru> selectAll();

    //根据用户姓名查询
    public List<Guru> selectByUser(String name);

}
