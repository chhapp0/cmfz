package com.baizhi.service.Impl;

import com.baizhi.dao.AlbumDATA1Mapper;
import com.baizhi.dao.BannerDATAMapper;
import com.baizhi.dao.ChapterDATAMapper;
import com.baizhi.dao.EssayDATAMapper;
import com.baizhi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.ibatis.ognl.DynamicSubscript.all;

/**
 * Created by ljf on 2017/6/16.
 */
public class OneServiceImpl {
    @Autowired
    private BannerDATAMapper bannerDATAMapper;

    @Autowired
    private AlbumDATA1Mapper albumMapper;

    @Autowired
    private ChapterDATAMapper chapterMapper;

    @Autowired
    private EssayDATAMapper essayDATAMapper;

    public One selectAll(String uid, String type, String sub_type){
        One one = new One();
        All all1 = new All();
        AlbumDATA1 albumDATA1=new AlbumDATA1();
        List<AlbumDATA1> list = new ArrayList<AlbumDATA1>();
        List<EssayDATA> list1 = new ArrayList<EssayDATA>();
        EssayDATA essayDATA=new EssayDATA();

        if (uid!=null && type.equals(all)) {
            List<BannerDATA> bannerDATAs = bannerDATAMapper.selectAll();
            List<AlbumDATA1> albumList = albumMapper.selectAllAdd();
            List<EssayDATA> essayDATAList = essayDATAMapper.selectAll();
            for (BannerDATA banner : bannerDATAs
                    ) {
                    banner.setThumbnail(banner.getThumbnail());
                    banner.setDescr(banner.getDescr());
                    banner.setId(banner.getId());
                    one.setHeader(banner);
            }
            for (AlbumDATA1 album : albumList
                    ) {
                Integer integer = chapterMapper.selectMany(album.getId());
                albumDATA1.setId(album.getId());
                albumDATA1.setSet_count(integer);
                albumDATA1.setThumbnail(album.getThumbnail());
                Date createDate = album.getCreate_date();
                albumDATA1.setCreate_date(createDate);
                albumDATA1.setAuthor(album.getAuthor());
                albumDATA1.setTitle(album.getTitle());
                albumDATA1.setScore(0);
                list.add(album);
                all1.setAlbumDATA1List(list);
                one.setBody(all1);
            }

            for (EssayDATA essay : essayDATAList) {
                String gurname = essayDATAMapper.selectGuru(essay.getId());
                Integer count = essayDATAMapper.selectMany();
                albumDATA1.setId(essay.getId());
                albumDATA1.setTitle(essay.getTitle());
                albumDATA1.setSet_count(count);
                albumDATA1.setCreate_date(essay.getCreate_date());
                albumDATA1.setAuthor(gurname);
                albumDATA1.setThumbnail(essay.getLink());
                albumDATA1.setType(1);
                list1.add(essay);
                all1.setEssayDATAList(list1);
                one.setBody(all1);
            }
            return one;

            
        } else if(uid !=null && type.equals("wen")){
            one.setHeader(null);
            List<AlbumDATA1> albumDATAs = albumMapper.selectAll();
            all1.setAlbumDATA1List(albumDATAs);
            one.setBody(all1);
            return one;
        }else if(uid !=null && type.equals("si")){
            if(sub_type.equals("xmfy")){
                one.setHeader(null);
                List<EssayDATA> essayDATAs = essayDATAMapper.selectAll();
                all1.setEssayDATAList(essayDATAs);
                one.setBody(all1);
                return one;
            }else {
                List<EssayDATA> essayDATAList = essayDATAMapper.selectUserGuru(uid);
                one.setHeader(null);
                all1.setEssayDATAList(essayDATAList);
                one.setBody(all1);
            }
        }
        return null;
    }
}
