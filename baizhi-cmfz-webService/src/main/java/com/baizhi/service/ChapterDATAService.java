package com.baizhi.service;

import com.baizhi.entity.ChapterDATA;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
public interface ChapterDATAService {
    public void add(ChapterDATA ChapterDATA);
    public void delete(String id);
    public void update(ChapterDATA ChapterDATA);

    public ChapterDATA queryOne(String id);
    public Page<ChapterDATA> queryAll(Integer pageNum, Integer rows);
    public void deleteAlbum(String id);
    public Integer selectMany(String id);
    public List<ChapterDATA> quertAll1(String id);
}
