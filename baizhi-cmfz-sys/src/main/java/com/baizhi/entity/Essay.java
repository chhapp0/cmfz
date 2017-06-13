package com.baizhi.entity;

import java.util.Date;

/**文章表
 *  id                   varchar(40)                    not null,
 title                varchar(40),
 flag                 varchar(40),
 pubDate              date,
 tid                  varchar(40),
 link                 varchar(40),
 */
public class Essay {
    private String id;

    private String title;

    private String flag;

    private Date pubdate;

    private Guru guru;

    private String link;

    public Essay() {
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", flag='" + flag + '\'' +
                ", pubdate=" + pubdate +
                ", guru=" + guru +
                ", link='" + link + '\'' +
                '}';
    }

    public Essay(String id, String title, String flag, Date pubdate, Guru guru, String link) {
        this.id = id;
        this.title = title;
        this.flag = flag;
        this.pubdate = pubdate;
        this.guru = guru;
        this.link = link;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}