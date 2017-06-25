package com.baizhi.service.Impl;

import com.baizhi.dao.IphoneDAO;
import com.baizhi.entity.Iphone;
import com.baizhi.service.IphoneService;
import com.baizhi.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ljf on 2017/6/22.
 */
@Service("/iphoneService")
@Transactional
public class IphoneServiceImpl implements IphoneService {
    @Autowired
    private IphoneDAO iphoneDAO;


    public void insert(Iphone iphone) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        long id = idWorker.nextId();
        System.out.println(id);
        String id1=String.valueOf(id);
        iphone.setId(id1);
        iphone.setDate(new Date());
        iphone.setFlag(0);
        System.out.println(iphone+"业务层");
        iphoneDAO.insert(iphone);
    }

    public void delete(String id) {
        iphoneDAO.delete(id);
    }

    public void update(Iphone iphone) {
        iphone.setDate(new Date());
        iphoneDAO.update(iphone);
    }

    public Iphone selectOne(String id) {
        Iphone iphone = iphoneDAO.selectOne(id);
        return iphone;
    }

    public Iphone selectHref(String href) {
        Iphone iphone = iphoneDAO.selectHref(href);
        return iphone;
    }

    public List<Iphone> selectAll() {
        List<Iphone> iphoneList = iphoneDAO.selectAll();
        return iphoneList;
    }
}
