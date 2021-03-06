package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.EssayMapper;
import com.baizhi.entity.Essay;
import com.baizhi.service.EssayService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    public Page<Essay> queryAll(Integer pageNum,Integer rows) {
        Page<Essay> page = PageHelper.startPage(pageNum, rows);
        List<Essay> essayList = essayMapper.selectAll();
        return page;
    }

    public void deleteGuru(String id) {
        essayMapper.deleteGuru(id);
    }
}
