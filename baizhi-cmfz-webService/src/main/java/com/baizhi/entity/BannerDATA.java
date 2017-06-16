package com.baizhi.entity;

/**
 * 轮播图表
 * id                   varchar(40)                    not null,
 "desc"               varchar(40),
 thumbnail            varchar(200),
 btype                 integer(4),
 */
public class BannerDATA {
    private String id;

    private String descr;

    private String thumbnail;


    public BannerDATA() {
    }

    public BannerDATA(String id, String descr, String thumbnail) {
        this.id = id;
        this.descr = descr;
        this.thumbnail = thumbnail;
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

    @Override
    public String toString() {
        return "BannerDATA{" +
                "id='" + id + '\'' +
                ", descr='" + descr + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}