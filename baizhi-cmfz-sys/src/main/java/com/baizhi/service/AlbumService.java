package com.baizhi.service;

import com.baizhi.entity.Album;
import com.github.pagehelper.Page;

/**
 * Created by ljf on 2017/6/12.
 */
public interface AlbumService {
    public void add(Album album);
    public void delete(String id);
    public void update(Album album);

    public Album queryOne(String id);
    public Page<Album> queryAll(Integer pageNum, Integer rows);
    public java.util.List<Album> queryAllAdd();
}
