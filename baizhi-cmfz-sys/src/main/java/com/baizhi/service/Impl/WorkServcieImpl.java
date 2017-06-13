package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.WorkMapper;
import com.baizhi.entity.Work;
import com.baizhi.service.WorkService;
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

    public List<Work> queryAll() {
        List<Work> workList = workMapper.selectAll();
        return workList;
    }
}
