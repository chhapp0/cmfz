package com.baizhi.service.Impl;

import com.baizhi.util.SnowflakeIdWorker;
import com.baizhi.dao.EssayDATAMapper;
import com.baizhi.dao.GuruMapper;
import com.baizhi.entity.GuruDATA;
import com.baizhi.service.GuruService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Service("guruService")
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruMapper guruMapper;
    @Autowired
    private EssayDATAMapper essayMapper;

    public void add(GuruDATA guru) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id1 = String.valueOf(idWorker.nextId());
        guru.setId(id1);
        guruMapper.insert(guru);
    }

    public void delete(String id) {
     /*   GuruDATA guru = guruMapper.selectByPrimaryKey(id);
       *//* List<EssayDATA> essay = guru.getEssay();
        for (EssayDATA ess:essay
             ) {
            essayMapper.deleteByPrimaryKey(ess.getId());
        }*//*
        essayMapper.deleteGuru(id);
        userMapper.updateGuru(id);
        guruMapper.deleteByPrimaryKey(id);*/
    }

    public void update(GuruDATA guru) {
        guruMapper.updateByPrimaryKey(guru);
    }

    public GuruDATA queryOne(String id) {
        GuruDATA guru = guruMapper.selectByPrimaryKey(id);
        return guru;
    }

    public Page<GuruDATA> queryAll(Integer pageNum, Integer rows) {
        Page<GuruDATA> page = PageHelper.startPage(pageNum, rows);
        List<GuruDATA> guruList = guruMapper.selectAll();
        return page;
    }

    public List<GuruDATA> selectAll() {
        List<GuruDATA> guruList = guruMapper.selectAll();
        return guruList;
    }
}
