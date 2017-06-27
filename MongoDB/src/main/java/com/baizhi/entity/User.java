package com.baizhi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ljf on 2017/6/26.
 */

//mongodb 注解这个注解对应表
@Document(collection = "t_user")
public class User implements Serializable{
    @Id
    private String id;  //ID注解表示这个id为主键列
    private String name;
    private Date birthday;
    private Integer age;

    //关系属性统一用 DBRef注解
    @DBRef
    private List<Order> orderList;
    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public User(String name, Date birthday, Integer age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", orderList=" + orderList +
                '}';
    }
}
