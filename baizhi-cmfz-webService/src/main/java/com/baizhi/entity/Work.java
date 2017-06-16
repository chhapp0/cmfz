package com.baizhi.entity;

import java.util.Date;
import java.util.List;

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

    private User user;

    private Date createdate;

    private List<Counter> counter;

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

    public Work(String id, String category, User user, Date createdate) {
        this.id = id;
        this.category = category;
        this.user = user;
        this.createdate = createdate;
    }

    public Work() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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