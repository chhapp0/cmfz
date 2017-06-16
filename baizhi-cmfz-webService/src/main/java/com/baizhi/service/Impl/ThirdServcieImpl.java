package com.baizhi.service.Impl;

import com.baizhi.dao.AlbumDATA1Mapper;
import com.baizhi.dao.ChapterDATAMapper;
import com.baizhi.entity.AlbumDATA1;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.ChapterDATA;
import com.baizhi.entity.Third;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljf on 2017/6/17.
 */
public class ThirdServcieImpl {
    @Resource
    private AlbumDATA1Mapper albumDATAMapper;
    @Resource
    ChapterDATAMapper chapterDATAMapper;
    AlbumDATA1 albumDATA1=new AlbumDATA1();


    public Third queryOne(String id){
        List<ChapterDATA> list=new ArrayList<ChapterDATA>();
        Third third=new Third();
        AlbumDATA1 albumDATA = albumDATAMapper.selectByPrimaryKey(id);
        Integer many = chapterDATAMapper.selectMany(albumDATA.getId());
        ChapterDATA chapterDATA=new ChapterDATA();
        albumDATA1.setId(albumDATA.getId());
        albumDATA1.setThumbnail(albumDATA.getThumbnail());
        albumDATA1.setTitle(albumDATA.getTitle());
        albumDATA1.setAuthor(albumDATA.getAuthor());
        albumDATA1.setBroadcast(albumDATA.getBroadcast());
        albumDATA1.setBrief(albumDATA.getBrief());
        albumDATA1.setCreate_date(albumDATA.getCreate_date());
        albumDATA1.setScore(albumDATA.getScore());
        third.setIntroduction(albumDATA1);

        List<Chapter> chapterList = chapterDATAMapper.selectAll(albumDATA.getId());
        for (Chapter chapter:chapterList
             ) {
            chapterDATA.setDownload_url(chapter.getUrl());
            chapterDATA.setDuration(chapter.getDuration());
            chapterDATA.setSize(chapter.getCsize());
            chapterDATA.setTitle(chapter.getTitle());
            list.add(chapterDATA);
            third.setList(list);
        }
        return third;
    }
}
