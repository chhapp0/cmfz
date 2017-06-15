package com.baizhi.entity;

/**
 * 轮播图表
 * id                   varchar(40)                    not null,
 "desc"               varchar(40),
 thumbnail            varchar(200),
 btype                 integer(4),
 */
public class Banner {
    private String id;

    private String descr;

    private String thumbnail;

    private Integer btype;

    public Banner(String id, String descr, String thumbnail, Integer btype) {
        this.id = id;
        this.descr = descr;
        this.thumbnail = thumbnail;
        this.btype = btype;
    }

    public Banner() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getBtype() {
        return btype;
    }

    public void setBtype(Integer btype) {
        this.btype = btype;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", descr='" + descr + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", btype=" + btype +
                '}';
    }
}