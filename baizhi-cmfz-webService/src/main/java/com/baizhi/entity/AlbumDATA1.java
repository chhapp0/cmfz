package com.baizhi.entity;

import java.util.Date;

/**
 * Created by ljf on 2017/6/16.
 */
public class AlbumDATA1 {
    private String id;
    private String thumbnail;
    private String title;
    private Integer score;
    private String author;
    private String broadcast;
    private Integer set_count;
    private String brief;
    private Date create_date;
    private Integer type;

    public AlbumDATA1() {
    }

    public AlbumDATA1(String id, String thumbnail, String title, Integer score, String author, String broadcast, Integer set_count, String brief, Date create_date, Integer type) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.set_count = set_count;
        this.brief = brief;
        this.create_date = create_date;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public Integer getSet_count() {
        return set_count;
    }

    public void setSet_count(Integer set_count) {
        this.set_count = set_count;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AlbumDATA1{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", set_count=" + set_count +
                ", brief='" + brief + '\'' +
                ", create_date=" + create_date +
                ", type=" + type +
                '}';
    }
}
