package com.baizhi.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ljf on 2017/6/15.
 */
@XmlRootElement(name="alls")
public class All implements Serializable{
    private List<AlbumDATA1> albumDATAList;
    private List<EssayDATA> essayDATAList;
    public All() {
    }

    public All(List<AlbumDATA1> albumDATAList, List<EssayDATA> essayDATAList) {
        this.albumDATAList = albumDATAList;
        this.essayDATAList = essayDATAList;
    }

    public List<AlbumDATA1> getAlbumDATA1List() {
        return albumDATAList;
    }

    public void setAlbumDATA1List(List<AlbumDATA1> albumDATAList) {
        this.albumDATAList = albumDATAList;
    }

    public List<EssayDATA> getEssayDATAList() {
        return essayDATAList;
    }

    public void setEssayDATAList(List<EssayDATA> essayDATAList) {
        this.essayDATAList = essayDATAList;
    }

    @Override
    public String toString() {
        return "All{" +
                "albumDATAList=" + albumDATAList +
                ", essayDATAList=" + essayDATAList +
                '}';
    }
}
