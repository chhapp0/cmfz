package com.baizhi.entity;

/**
 * 城市表
 *    id                   varchar(40)                    not null,
    name                 varchar(40),
     pid                  varchar(40),
 */
public class City {
    private String id;

    private String name;

    private Province province;

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", province=" + province +
                '}';
    }

    public City(String id, String name, Province province) {
        this.id = id;
        this.name = name;
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
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


}