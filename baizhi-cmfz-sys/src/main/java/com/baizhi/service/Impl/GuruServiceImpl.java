package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.EssayMapper;
import com.baizhi.dao.GuruMapper;
import com.baizhi.dao.UserMapper;
import com.baizhi.entity.Guru;
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
    private EssayMapper essayMapper;
    @Autowired
    private UserMapper userMapper;

    public void add(Guru guru) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id1 = String.valueOf(idWorker.nextId());
        guru.setId(id1);
        guruMapper.insert(guru);
    }

    public void delete(String id) {
        Guru guru = guruMapper.selectByPrimaryKey(id);
       /* List<Essay> essay = guru.getEssay();
        for (Essay ess:essay
             ) {
            essayMapper.deleteByPrimaryKey(ess.getId());
        }*/
        essayMapper.deleteGuru(id);
        userMapper.updateGuru(id);
        guruMapper.deleteByPrimaryKey(id);
    }

    public void update(Guru guru) {
        guruMapper.updateByPrimaryKey(guru);
    }

    public Guru queryOne(String id) {
        Guru guru = guruMapper.selectByPrimaryKey(id);
        return guru;
    }

    public Page<Guru> queryAll(Integer pageNum, Integer rows) {
        Page<Guru> page = PageHelper.startPage(pageNum, rows);
        List<Guru> guruList = guruMapper.selectAll();
        return page;
    }

    public List<Guru> selectAll() {
        List<Guru> guruList = guruMapper.selectAll();
        return guruList;
    }
}
