package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by ljf on 2017/6/12.
 */
public interface AlbumService {
    public void add(Album album);
    public void delete(String id);
    public void update(Album album);

    public Album queryOne(String id);
    public List<Album> queryAll();
}
