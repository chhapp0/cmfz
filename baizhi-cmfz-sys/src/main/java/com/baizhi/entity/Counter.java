package com.baizhi.entity;

import java.util.Date;

/**
 * 计数器
 *id                   varchar(40)                    not null,
 姓名                   varchar(40),
 count                varchar(10),
 wid                  varchar(40),   功课外键
 */
public class Counter {
    private String id;

    private String name;

    private String count;

    private Work work;

    private Date createdate;



    public Counter() {
    }

    public Counter(String id, String name, String count, Work work, Date createdate) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.work = work;
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                ", work=" + work +
                ", createdate=" + createdate +
                '}';
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Date getCreatedate() {
        return createdate;
    }


    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}