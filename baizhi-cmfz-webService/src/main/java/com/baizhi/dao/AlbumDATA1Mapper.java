package com.baizhi.dao;

import com.baizhi.entity.AlbumDATA1;

import java.util.List;

public interface AlbumDATA1Mapper {
    int deleteByPrimaryKey(String id);

    int insert(AlbumDATA1 record);

  //  int insertSelective(Album record);

    AlbumDATA1 selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(AlbumDATA1 record);

    public List<AlbumDATA1> selectAll();
    public List<AlbumDATA1> selectAllAdd();

}