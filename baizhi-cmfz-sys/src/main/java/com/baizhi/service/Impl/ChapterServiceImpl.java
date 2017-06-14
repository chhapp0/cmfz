package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.ChapterMapper;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    public void add(Chapter chapter) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        chapter.setId(id);


      /*  Album album = chapter.getAlbum();
        String albumId = album.getId();
        chapter.getAlbum().setId(albumId);*/

        chapterMapper.insert(chapter);
    }

    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }

    public void update(Chapter chapter) {

/*
        Album album = chapter.getAlbum();
        String albumId = album.getId();
        chapter.getAlbum().setId(albumId);*/

        chapterMapper.updateByPrimaryKey(chapter);
    }

    public Chapter queryOne(String id) {
        Chapter chapter = chapterMapper.selectByPrimaryKey(id);
        return chapter;
    }

    public Page<Chapter> queryAll(Integer pageNum, Integer rows) {
        Page<Chapter> page = PageHelper.startPage(pageNum, rows);
        List<Chapter> chapterList = chapterMapper.selectAll();
        return page;
    }

    public void deleteAlbum(String id) {
        chapterMapper.deleteAlbum(id);
    }
}
