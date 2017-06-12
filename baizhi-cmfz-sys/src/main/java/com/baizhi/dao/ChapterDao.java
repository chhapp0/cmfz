package com.baizhi.dao;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface ChapterDao {

    public void insertChapter(Chapter chapter);

    public void deleteChapter(String id);

    public void updateChapter(Chapter chapter);

    public Chapter selectOne(String id);

    public List<Chapter> selectAll();

}
