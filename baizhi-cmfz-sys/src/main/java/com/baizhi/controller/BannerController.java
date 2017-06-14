package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    @Resource
    private BannerService bannerService;
    /**
     * 查找所有轮播图
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response) throws IOException {
        List<Banner> bannerList = bannerService.queryAll();
        String bannerString = JSONObject.toJSONString(bannerList);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(bannerString);
    }

    /**
     * 查一个轮播图
     */
    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(HttpServletResponse response,String id) throws IOException {
        Banner banner = bannerService.queryOne(id);
        String bannerString = JSONObject.toJSONString(banner);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(bannerString);
    }

    /**
     * 修改轮播图
     */
    @RequestMapping("/update")
    public String update(Banner banner){
        bannerService.update(banner);
        return "redirect:/back/page/banner/show.jsp";
    }

    /**
     * 添加轮播图
     */
    @RequestMapping("/insert")
    public String insert(Banner banner){
        bannerService.add(banner);
        return "redirect:/back/page/banner/show.jsp";
    }

    /**
     * 删除轮播图
     */
    @RequestMapping("/delete")
    public String delete(String id){
        bannerService.delte(id);
        return "redirect:/back/page/banner/show.jsp";
    }
}
