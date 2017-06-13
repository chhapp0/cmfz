package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
public interface ChapterService {
    public void add(Chapter chapter);
    public void delete(String id);
    public void update(Chapter chapter);

    public Chapter queryOne(String id);
    public List<Chapter> queryAll();
}
