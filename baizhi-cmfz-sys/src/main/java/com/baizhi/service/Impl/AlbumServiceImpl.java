package com.baizhi.service.Impl;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.dao.AlbumMapper;
import com.baizhi.dao.ChapterMapper;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    public void add(Album album) {
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        album.setId(id);
        album.setCreatedate(new Date());
        albumMapper.insert(album);
    }

    public void delete(String id) {
        Album album = albumMapper.selectByPrimaryKey(id);
        List<Chapter> chapter = album.getChapter();
        for (Chapter cha:chapter
             ) {
            chapterMapper.deleteByPrimaryKey(cha.getId());
        }
        albumMapper.deleteByPrimaryKey(id);
    }

    public void update(Album album) {
        albumMapper.updateByPrimaryKey(album);
    }

    public Album queryOne(String id) {
        Album album = albumMapper.selectByPrimaryKey(id);
        return album;
    }

    public List<Album> queryAll() {
        List<Album> albumList = albumMapper.selectAll();
        return albumList;
    }
}
