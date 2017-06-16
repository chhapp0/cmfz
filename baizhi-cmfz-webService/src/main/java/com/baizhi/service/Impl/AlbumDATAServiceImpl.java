package com.baizhi.service.Impl;

import com.baizhi.dao.ChapterDATAMapper;
import com.baizhi.dao.EssayDATAMapper;
import com.baizhi.service.AlbumDATAService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
@Service("AlbumDATAService")
@Transactional
@WebService
public class AlbumDATAServiceImpl implements AlbumDATAService{
    @Autowired
    private AlbumDATAMapper albumMapper;

    @Autowired
    private ChapterDATAMapper chapterMapper;

    @Autowired
    private EssayDATAMapper essayDATAMapper;



    public void add(AlbumDATA album) {
        /*SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        album.setId(id);
        album.setCreatedate(new Date());
        albumMapper.insert(album);*/
    }

    public void delete(String id) {
       /* chapterMapper.deleteAlbum(id);
        albumMapper.deleteByPrimaryKey(id);*/
    }

    public void update(AlbumDATA album) {
       /* album.setCreatedate(new Date());

        albumMapper.updateByPrimaryKey(album);*/

    }

    public AlbumDATA queryOne(String id) {
        AlbumDATA album = albumMapper.selectByPrimaryKey(id);
        Integer integer = chapterMapper.selectMany(id);
        album.setSet_count(integer);
        return album;
    }

    public Page<AlbumDATA> queryAll(Integer pageNum,Integer rows) {
        Page<AlbumDATA> page = PageHelper.startPage(pageNum, rows);
        List<AlbumDATA> albumList = albumMapper.selectAll();
        return page;
    }

    //body
    public List<AlbumDATA> queryAllAdd() {
      /*  List<Object> list=new ArrayList<Object>();
        List<AlbumDATA> albumList = albumMapper.selectAllAdd();
        List<EssayDATA> essayDATAList = essayDATAMapper.selectAll();
        for (AlbumDATA album:albumList
             ) {
           Integer integer = chapterMapper.selectMany(album.getId());
            album.setId(album.getId());
           album.setSet_count(integer);
            album.setThumbnail(album.getThumbnail());
            Date createDate = album.getCreate_date();
            album.setCreate_date(createDate);
            album.setAuthor(album.getAuthor());
            album.setTitle(album.getTitle());
            album.setType(0);
            list.add(album);
            System.out.println(list+"业务层BODY-------Album");
        }

        for (EssayDATA essay:essayDATAList){
            Integer count = essayDATAMapper.selectMany();
            essay.setId(essay.getId());
            essay.setTitle(essay.getTitle());
            essay.setSet_count(count);
            essay.setCreate_date(essay.getCreate_date());
            essay.setGuru(essay.getGuru());
            essay.setLink(essay.getLink());
            essay.setType("1");
            list.add(essay);
        }
        */
        return null;
    }
}
