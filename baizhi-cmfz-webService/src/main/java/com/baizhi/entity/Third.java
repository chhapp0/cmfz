package com.baizhi.entity;

import java.util.List;

/**
 * Created by ljf on 2017/6/16.
 */
public class Third {
    private AlbumDATA1 introduction;

    private List<ChapterDATA> list;

    public Third() {
    }

    public Third(AlbumDATA1 introduction, List<ChapterDATA> list) {
        this.introduction = introduction;
        this.list = list;
    }

    public AlbumDATA1 getIntroduction() {
        return introduction;
    }

    public void setIntroduction(AlbumDATA1 introduction) {
        this.introduction = introduction;
    }

    public List<ChapterDATA> getList() {
        return list;
    }

    public void setList(List<ChapterDATA> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Third{" +
                "introduction=" + introduction +
                ", list=" + list +
                '}';
    }
}
