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
public class EssayDATA {
    private String id;

    private String title;

   private String type;

    private Date create_date;

    private GuruDATA guru;

    private String link;

    private String ext;

    private Integer set_count;
    /* public EssayDATA() {
    }

    public GuruDATA getGuru() {
        return guru;
    }

    public void setGuru(GuruDATA guru) {
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "EssayDATA{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", flag='" + flag + '\'' +
                ", pubdate=" + pubdate +
                ", guru=" + guru +
                ", link='" + link + '\'' +
                '}';
    }

    public EssayDATA(String id, String title, String flag, Date pubdate, GuruDATA guru, String link) {
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
    }*/

    public EssayDATA() {
    }

    public EssayDATA(String id, String title, String type, Date create_date, GuruDATA guru, String link, String ext, Integer set_count) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.create_date = create_date;
        this.guru = guru;
        this.link = link;
        this.ext = ext;
        this.set_count = set_count;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public GuruDATA getGuru() {
        return guru;
    }

    public void setGuru(GuruDATA guru) {
        this.guru = guru;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Integer getSet_count() {
        return set_count;
    }

    public void setSet_count(Integer set_count) {
        this.set_count = set_count;
    }

    @Override
    public String toString() {
        return "EssayDATA{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", create_date=" + create_date +
                ", guru=" + guru +
                ", link='" + link + '\'' +
                ", ext='" + ext + '\'' +
                ", set_count=" + set_count +
                '}';
    }
}