package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/11.
 */
public interface BannerDao {

    public void insertBanner(Banner banner);

    public void deleteBanner(String id);

    public void updateBanner(Banner banner);

    public Banner selectOne(String id);

    public List<Banner> selectAll();

}
