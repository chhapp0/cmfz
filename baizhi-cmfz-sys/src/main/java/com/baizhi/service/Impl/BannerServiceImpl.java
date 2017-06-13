package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.BannerMapper;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
@Service("bannerService")
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerMapper bannerMapper;

    public void add(Banner banner) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        banner.setId(id);
        bannerMapper.insert(banner);

    }

    public void delte(String id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    public void update(Banner banner) {
         bannerMapper.updateByPrimaryKey(banner);
    }

    public Banner queryOne(String id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        return banner;
    }

    public List<Banner> queryAll() {
        List<Banner> bannerList = bannerMapper.selectAll();
        return bannerList;
    }
}
