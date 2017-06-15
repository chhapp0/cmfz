package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Moduleobject;
import com.baizhi.service.BannerService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

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
    public void queryAll(HttpServletResponse response,Integer page, Integer rows) throws IOException {
        Page<Banner> banners = bannerService.queryAll(page, rows);
        Moduleobject moduleobject = new Moduleobject();
        moduleobject.setRows(banners.getResult());
        moduleobject.setTotal(banners.getTotal());
        String bannerString = JSONObject.toJSONString(moduleobject);
        response.setContentType("application/json;charset=utf-8");

        System.out.println(bannerString+"&&&&&&&&&&&&&&&");
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
    public void update(Banner banner,HttpServletRequest request,MultipartFile aaa) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();

        banner.setThumbnail(path+"."+aaa.getOriginalFilename());
        bannerService.update(banner);
        //return "redirect:/back/page/banner/show.jsp";
    }

    /**
     * 添加轮播图
     */
    @RequestMapping("/add")
    public void add(Banner banner, HttpServletRequest request, MultipartFile aaa) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();

        banner.setThumbnail(path+"."+aaa.getOriginalFilename());
        //return "/back/page/banner/info/show.jsp";
        bannerService.add(banner);

    }

    /**
     * 删除轮播图
     */
    @RequestMapping("/delete")
    public void delete(String id){
        bannerService.delte(id);
        //return "redirect:/back/page/banner/show.jsp";
    }
}
