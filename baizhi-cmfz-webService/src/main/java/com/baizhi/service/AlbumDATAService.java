package com.baizhi.service;

import com.baizhi.entity.AlbumDATA1;
import com.github.pagehelper.Page;

/**
 * Created by ljf on 2017/6/12.
 */
public interface AlbumDATAService {
    public void add(AlbumDATA1 AlbumDATA1);
    public void delete(String id);
    public void update(AlbumDATA1 AlbumDATA1);

    public AlbumDATA1 queryOne(String id);
    public Page<AlbumDATA1> queryAll(Integer pageNum, Integer rows);
    public java.util.List<AlbumDATA1> queryAllAdd();
}
