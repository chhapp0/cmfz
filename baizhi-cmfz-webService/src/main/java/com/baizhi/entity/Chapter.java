package com.baizhi.entity;

/**
 * 章节表
 * id                   varchar(40)                    not null,
 title                varchar(40),
 url                  varchar(200),
 csize                 varchar(20),
 pid                  varchar(40),
 duration             varchar(40),
 */
public class Chapter {
    private String id;

    private String title;

    private String url;

    private String csize;

    private String duration;

    public Chapter() {
    }

    public Chapter(String id, String title, String url, String csize, String duration) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.csize = csize;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCsize() {
        return csize;
    }

    public void setCsize(String csize) {
        this.csize = csize;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", csize='" + csize + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}