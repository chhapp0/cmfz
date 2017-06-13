package com.baizhi.entity;

import java.util.List;

/**
 * 省份表
 *   id                   varchar(40)                    not null,
 pname                varchar(40),
 */
public class Province {
    private String id;

    private String pname;
    private List<City> city;
    public Province() {
    }

    public List<City> getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id='" + id + '\'' +
                ", pname='" + pname + '\'' +
                ", city=" + city +
                '}';
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public Province(String id, String pname, List<City> city) {
        this.id = id;
        this.pname = pname;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}