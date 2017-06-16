package com.baizhi.service.Impl;

import com.baizhi.dao.ChapterDATAMapper;
import com.baizhi.entity.ChapterDATA;
import com.baizhi.service.ChapterDATAService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
@Service("ChapterDATAService")
@Transactional
public class ChapterDATAServiceImpl implements ChapterDATAService {

    @Autowired
    private ChapterDATAMapper chapterDATAMapper;
    public void add(ChapterDATA ChapterDATA) {

    }

    public void delete(String id) {

    }

    public void update(ChapterDATA ChapterDATA) {

    }

    public ChapterDATA queryOne(String id) {
        return null;
    }

    public Page<ChapterDATA> queryAll(Integer pageNum, Integer rows) {
        return null;
    }

    public void deleteAlbum(String id) {

    }

    public Integer selectMany(String id) {
        return null;
    }

    public List<ChapterDATA> quertAll1(String id) {
        List<ChapterDATA> chapterDATAList = chapterDATAMapper.selectAll(id);
        return chapterDATAList;
    }
}
