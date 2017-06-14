package com.baizhi.dao.none;

import com.baizhi.entity.Essay;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface EssayDao {

    public void insertEssay(Essay essay);

    public void deleteEssay(String id);

    public void updateEssay(Essay essay);

    public Essay selectOne(String id);

    public List<Essay> selectAll();

    //根据上师姓名查询
    public List<Essay> selectByGuru(String name);

}
