package com.baizhi.dao.none;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface AlbumDao {

    public void insertAlbum(Album album);

    public void deleteAlbum(String id);

    public void updateAlbum(Album album);

    public Album selectOne(String id);

    public List<Album> selectAll();



}
