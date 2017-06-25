package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ljf on 2017/6/22.
 */
public class Iphone implements Serializable{
    private String id;
    private String name;
    private Date date;
    private String info;
    private String href;
    private Double price;
    private Integer flag;
    private String score;
    public Iphone() {
    }

    public Iphone(String id, String name, Date date, String info, String href, Double price, Integer flag, String score) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.info = info;
        this.href = href;
        this.price = price;
        this.flag = flag;
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Iphone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", info='" + info + '\'' +
                ", href='" + href + '\'' +
                ", price=" + price +
                ", flag=" + flag +
                ", score='" + score + '\'' +
                '}';
    }
}
