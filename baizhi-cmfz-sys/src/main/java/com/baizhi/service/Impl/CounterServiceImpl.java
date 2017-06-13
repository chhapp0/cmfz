package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.CounterMapper;
import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Service("counterService")
@Transactional
public class CounterServiceImpl implements CounterService {
    @Autowired
    private CounterMapper counterMapper;
    public void add(Counter counter) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        counter.setCreatedate(new Date());

        counter.setId(id);
        counterMapper.insert(counter);
    }

    public void delete(String id) {
        counterMapper.deleteByPrimaryKey(id);
    }

    public void update(Counter counter) {
        counter.setCreatedate(new Date());
        counterMapper.updateByPrimaryKey(counter);
    }

    public Counter queryOne(String id) {
        Counter counter = counterMapper.selectByPrimaryKey(id);
        return counter;
    }

    public List<Counter> queryAll() {
        List<Counter> counterList = counterMapper.selectAll();
        return counterList;
    }
}
