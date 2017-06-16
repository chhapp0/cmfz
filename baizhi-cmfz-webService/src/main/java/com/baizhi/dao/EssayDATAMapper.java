package com.baizhi.dao;

import com.baizhi.entity.EssayDATA;

import java.util.List;

public interface EssayDATAMapper {
    int deleteByPrimaryKey(String id);

    int insert(EssayDATA record);

   //int insertSelective(EssayDATA record);

    EssayDATA selectByPrimaryKey(String id);

    //int updateByPrimaryKeySelective(EssayDATA record);

    int updateByPrimaryKey(EssayDATA record);

    public void deleteGuru(String id);

    public List<EssayDATA> selectAll();

    public Integer selectMany();

    public String selectGuru(String id);

    public List<EssayDATA> selectUserGuru(String id);

    public List<EssayDATA> selectUserEss(String flag);
    public List<EssayDATA> selectAllEss(String flag);
}