package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.WorkMapper;
import com.baizhi.entity.Work;
import com.baizhi.service.WorkService;
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
@Service("workService")
@Transactional
public class WorkServcieImpl implements WorkService {
    @Autowired
    private WorkMapper workMapper;


    public void add(Work work) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        work.setId(id);
        work.setCreatedate(new Date());

        String id1 = work.getUser().getId();
        work.getUser().setId(id1);

        workMapper.insert(work);
    }

    public void delete(String id) {

        workMapper.deleteByPrimaryKey(id);
    }

    public void update(Work work) {
        workMapper.updateByPrimaryKey(work);
    }

    public Work queryOne(String id) {
        Work work = workMapper.selectByPrimaryKey(id);
        return work;
    }

    public Page<Work> queryAll(Integer pageNum,Integer rows) {
        Page<Work> page = PageHelper.startPage(pageNum, rows);
        List<Work> workList = workMapper.selectAll();
        return page;
    }

    public void deleteUser(String id) {
        workMapper.deleteUser(id);
    }


    public void insert2(Work work) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());

    }
}
