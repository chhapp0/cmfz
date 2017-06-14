package com.baizhi.entity;

import java.util.Date;

/**
 * 专辑表
 * id                   varchar(40)                    not null,
 thumbnail            varchar(40),
 title                varchar(40),
 score                double,
 author               varcahr(40),
 broadcast            varchar(40),
 createDate           date,
 brief                varchar(1000),
 */
public class Album {
    private String id;

    private String thumbnail;

    private String title;

    private Double score;

    private String author;

    private String broadcast;

    private Date createdate;

    //private List<Chapter> chapter;

    private String brief;


    public Album() {
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Album(String id, String thumbnail, String title, Double score, String author, String broadcast, Date createdate, String brief) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.createdate = createdate;
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", createdate=" + createdate +
                ", brief='" + brief + '\'' +
                '}';
    }
}