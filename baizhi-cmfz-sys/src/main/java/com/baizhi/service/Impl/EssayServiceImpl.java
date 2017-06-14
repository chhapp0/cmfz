package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.EssayMapper;
import com.baizhi.entity.Essay;
import com.baizhi.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Service("essayService")
@Transactional
public class EssayServiceImpl implements EssayService {
    @Autowired
    private EssayMapper essayMapper;

    public void add(Essay essay) {
        SnowflakeIdWorker idWorker =new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        essay.setId(id);
        essay.setPubdate(new Date());


        String id1 = essay.getGuru().getId();
        essay.getGuru().setId(id1);

        essayMapper.insert(essay);
    }

    public void delete(String id) {
        essayMapper.deleteByPrimaryKey(id);
    }

    public void update(Essay essay) {
        essayMapper.updateByPrimaryKey(essay);
    }

    public Essay queryOne(String id) {
        Essay essay = essayMapper.selectByPrimaryKey(id);

        return essay;
    }

    public List<Essay> queryAll() {
        List<Essay> essayList = essayMapper.selectAll();
        return essayList;
    }
}
