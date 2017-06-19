package com.baizhi.service.Impl;

import com.baizhi.dao.AlbumDATA1Mapper;
import com.baizhi.dao.ChapterDATAMapper;
import com.baizhi.entity.AlbumDATA1;
import com.baizhi.entity.ChapterDATA;
import com.baizhi.service.AlbumDATA1Service;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
@Service("AlbumDATAService")
@Transactional
public class AlbumDATA1ServiceImpl implements AlbumDATA1Service {
    @Autowired
    private AlbumDATA1Mapper albumMapper;

    @Autowired
    private ChapterDATAMapper chapterMapper;


    public void add(AlbumDATA1 albumDATA1) {

    }

    public void delete(String id) {
       /* chapterMapper.deleteAlbum(id);
        albumMapper.deleteByPrimaryKey(id);*/
    }

    public void update(AlbumDATA1 album) {
       /* album.setCreatedate(new Date());

        albumMapper.updateByPrimaryKey(album);*/

    }

    public AlbumDATA1 queryOne(String id) {
        AlbumDATA1 album = albumMapper.selectByPrimaryKey(id);
        Integer integer = chapterMapper.selectMany(id);
        List<ChapterDATA> chapterDATAList = chapterMapper.selectAll(id);
        album.setSet_count(integer);
        album.setAuthor(album.getAuthor());
        album.setCreate_date(album.getCreate_date());
        album.setTitle(album.getTitle());
        album.setBrief(album.getBrief());
        album.setBroadcast(album.getBroadcast());
        album.setThumbnail(album.getThumbnail());
        album.setScore(album.getScore());
        System.out.println(album+"业务层AlbumDATA1");
        return album;
    }

    public Page<AlbumDATA1> queryAll(Integer pageNum,Integer rows) {
       /* Page<AlbumDATA> page = PageHelper.startPage(pageNum, rows);
        List<AlbumDATA> albumList = albumMapper.selectAll();*/
        return null;
    }

    //body
    public List<AlbumDATA1> queryAllAdd() {
      /*  List<AlbumDATA1> list=new ArrayList<AlbumDATA1>();
        List<AlbumDATA1> albumList = albumMapper.selectAllAdd();
        for (AlbumDATA1 album:albumList
             ) {
           Integer integer = chapterMapper.selectMany(album.getId());
           album.setSet_count(integer);
            album.setThumbnail(album.getThumbnail());
            Date createDate = album.getCreate_date();
            album.setCreate_date(createDate);
            album.setAuthor(album.getAuthor());
            album.setTitle(album.getTitle());
            album.setType(album.getType());
            list.add(album);
            System.out.println(list+"业务层BODY-------Album");
        }*/
        return null;
    }
}
