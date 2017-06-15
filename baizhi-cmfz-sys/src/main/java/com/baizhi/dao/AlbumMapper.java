package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumMapper {
    int deleteByPrimaryKey(String id);

    int insert(Album record);

  //  int insertSelective(Album record);

    Album selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    public List<Album> selectAll();
    public List<Album> selectAllAdd();

}