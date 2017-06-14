package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.EssayMapper;
import com.baizhi.dao.GuruMapper;
import com.baizhi.entity.Essay;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
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

    public void add(Guru guru) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id1 = String.valueOf(idWorker.nextId());
        guru.setId(id1);
        guruMapper.insert(guru);
    }

    public void delete(String id) {
        Guru guru = guruMapper.selectByPrimaryKey(id);
        List<Essay> essay = guru.getEssay();
        for (Essay ess:essay
             ) {
            essayMapper.deleteByPrimaryKey(ess.getId());
        }
        guruMapper.deleteByPrimaryKey(id);
    }

    public void update(Guru guru) {
        guruMapper.updateByPrimaryKey(guru);
    }

    public Guru queryOne(String id) {
        Guru guru = guruMapper.selectByPrimaryKey(id);
        return guru;
    }

    public List<Guru> queryAll() {
        List<Guru> guruList = guruMapper.selectAll();
        return guruList;
    }
}
