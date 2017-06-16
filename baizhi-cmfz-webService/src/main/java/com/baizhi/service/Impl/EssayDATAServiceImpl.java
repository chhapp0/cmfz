package com.baizhi.service.Impl;

import com.baizhi.dao.EssayDATAMapper;
import com.baizhi.entity.EssayDATA;
import com.baizhi.service.EssayDATAService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Service("essayService")
@Transactional
public class EssayDATAServiceImpl implements EssayDATAService {
    @Autowired
    private EssayDATAMapper essayMapper;

    public void add(EssayDATA essay) {
      /*  SnowflakeIdWorker idWorker =new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        essay.setId(id);
        essay.setPubdate(new Date());*/
        essayMapper.insert(essay);
    }

    public void delete(String id) {
        essayMapper.deleteByPrimaryKey(id);
    }

    public void update(EssayDATA essay) {

        essayMapper.updateByPrimaryKey(essay);
    }

    public EssayDATA queryOne(String id) {
        EssayDATA essay = essayMapper.selectByPrimaryKey(id);
        return essay;
    }

    public Page<EssayDATA> queryAll(Integer pageNum, Integer rows) {
        Page<EssayDATA> page = PageHelper.startPage(pageNum, rows);
        List<EssayDATA> essayList = essayMapper.selectAll();
        return page;
    }

    public void deleteGuru(String id) {
        essayMapper.deleteGuru(id);
    }

    public List<EssayDATA> queryAllAdd() {
        List<EssayDATA> essayDATAs = essayMapper.selectAll();
        return essayDATAs;
    }

    public EssayDATA selectUserGuru(String id) {

        return null;
    }


}
