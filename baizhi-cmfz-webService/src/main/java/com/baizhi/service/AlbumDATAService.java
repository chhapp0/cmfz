package com.baizhi.service;

import com.github.pagehelper.Page;

/**
 * Created by ljf on 2017/6/12.
 */
public interface AlbumDATAService {
    public void add(AlbumDATA AlbumDATA);
    public void delete(String id);
    public void update(AlbumDATA AlbumDATA);

    public AlbumDATA queryOne(String id);
    public Page<AlbumDATA> queryAll(Integer pageNum, Integer rows);
    public java.util.List<AlbumDATA> queryAllAdd();
}
