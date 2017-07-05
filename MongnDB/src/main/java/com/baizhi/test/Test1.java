package com.baizhi.test;

import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ljf on 2017/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class Test1 {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insert(){
        User user=new User("zhangsan","123456");
        mongoTemplate.save(user);
        System.out.println(user);
    }

    @Test
    public void selectOne(){
        Query query=new Query();
        Criteria criteria=new Criteria("name");
        criteria.is("zhangsan");
        criteria.and("paw").is("123456");
        query.addCriteria(criteria);
        System.out.println("====");
        List<User> users = mongoTemplate.find(query, User.class);
        for (User user:users
             ) {
            System.out.println("=============");
            System.out.println(user.getName());
            System.out.println(user.getPaw()+"=-=-=-=-==-");
        }

        /*List<User> all = mongoTemplate.findAll(User.class);
        for (User user:all
                ) {
            System.out.println("=============");
            System.out.println(user.getName());
            System.out.println(user.getPaw()+"=-=-=-=-==-");
        }*/
    }
}
