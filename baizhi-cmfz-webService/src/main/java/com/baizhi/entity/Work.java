package com.baizhi.entity;

import java.util.Date;

/**
 * 功课表
 *  id                   varchar(40)                    not null,
 category             varchar(40),
 uid                  varchar(40),
 createDate           date,
 */
public class Work {
    private String id;

    private String category;

    private UserDATA user;

    private Date createdate;

    //private List<CounterDATA> counter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Work(String id, String category, UserDATA user, Date createdate) {
        this.id = id;
        this.category = category;
        this.user = user;
        this.createdate = createdate;
    }

    public Work() {
    }

    public UserDATA getUser() {
        return user;
    }

    public void setUser(UserDATA user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", user=" + user +
                ", createdate=" + createdate +
                '}';
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}