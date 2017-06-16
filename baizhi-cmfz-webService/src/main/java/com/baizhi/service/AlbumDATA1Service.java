package com.baizhi.service;

import com.baizhi.entity.AlbumDATA1;
import com.github.pagehelper.Page;

/**
 * Created by ljf on 2017/6/12.
 */
public interface AlbumDATA1Service {
    public void add(AlbumDATA1 albumDATA1);
    public void delete(String id);
    public void update(AlbumDATA1 albumDATA1);

    public AlbumDATA1 queryOne(String id);
    public Page<AlbumDATA1> queryAll(Integer pageNum, Integer rows);

}
