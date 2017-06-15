package com.baizhi.entity;


import java.util.List;

/**
 * 上师表
 *  id                   varchar(40)                    not null,
 name                 varchar(40),
 head                 varchar(100),
 */
public class Guru {
    private String id;

    private String name;

    private String head;

    private List<Essay> essay;

    public Guru() {
    }


    public Guru(String id, String name, String head, List<Essay> essay) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.essay = essay;
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

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public List<Essay> getEssay() {
        return essay;
    }

    public void setEssay(List<Essay> essay) {
        this.essay = essay;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", head='" + head + '\'' +
                ", essay=" + essay +
                '}';
    }
}