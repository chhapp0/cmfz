

package com.baizhi.test;

import com.baizhi.service.IphoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by ljf on 2017/6/12.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class Test1 {
    @Autowired
    private IphoneService iphoneService;
    //private IphoneDAO iphoneDAO;
    @Test
    public void aa() {
       // Analyzer analyzer=new IKAnalyzer();


      /* Iphone iphone=new Iphone("1","苹果4",new Date(),"11年划时代产品","www.baidu.com",4500.00,0,null);
      *//*  System.out.println(iphone);
        //iphoneService.insert(iphone);
        iphoneDAO.insert(iphone);*//*

      *//*  List<Iphone> iphoneList = iphoneDAO.selectAll();
        System.out.println(iphoneList);*//*
        iphoneDAO.update(iphone);*/
     /*   Iphone iphone = iphoneService.selectOne("327888961886224384");
        System.out.println(iphone);*/
    }
}


