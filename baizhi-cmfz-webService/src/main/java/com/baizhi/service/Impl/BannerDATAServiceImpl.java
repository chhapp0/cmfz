package com.baizhi.service.Impl;

import com.baizhi.dao.BannerDATAMapper;
import com.baizhi.entity.BannerDATA;
import com.baizhi.service.BannerDATAService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
@Service("BannerDATAService")
@Transactional
class BannerDATAServiceImpl implements BannerDATAService{
    @Autowired
    private BannerDATAMapper BannerDATAMapper;

    public void add(BannerDATA BannerDATA) {
     /*   SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        BannerDATA.setId(id);
        BannerDATAMapper.insert(BannerDATA);*/

    }

    public void delte(String id) {
        BannerDATAMapper.deleteByPrimaryKey(id);
    }

    public void update(BannerDATA BannerDATA) {
         BannerDATAMapper.updateByPrimaryKey(BannerDATA);
    }

    public BannerDATA queryOne(String id) {
        BannerDATA BannerDATA = BannerDATAMapper.selectByPrimaryKey(id);
        return BannerDATA;
    }

    public Page<BannerDATA> queryAll(Integer pageNum, Integer rows) {
        Page<BannerDATA> page = PageHelper.startPage(pageNum, rows);
        List<BannerDATA> BannerDATAList = BannerDATAMapper.selectAll();
        return  page;
    }

    public List<BannerDATA> queryAllAdd() {
        List<BannerDATA> bannerDATAList = BannerDATAMapper.selectAll();
        return bannerDATAList;
    }
}
