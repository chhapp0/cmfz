package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/29.
 */
public class User implements Serializable{
    private Integer id;
    private String name;
    private Date birthDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public User(Integer id, String name, Date birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
