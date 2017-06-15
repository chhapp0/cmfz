package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Moduleobject;
import com.baizhi.service.ChapterService;
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
@RequestMapping("/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response,Integer page, Integer rows) throws IOException {
        System.out.println(page+"章节"+rows);
        Page<Chapter> chapterPage = chapterService.queryAll(page, rows);
        Moduleobject moduleobject=new Moduleobject();

        moduleobject.setTotal(chapterPage.getTotal());
        moduleobject.setRows(chapterPage.getResult());
        String chapterString = JSONObject.toJSONString(moduleobject);

        System.out.println(chapterString+"章节");

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(chapterString);
    }
    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(String id,HttpServletResponse response) throws IOException {
        Chapter chapter = chapterService.queryOne(id);
        String chapterString = JSONObject.toJSONString(chapter);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(chapterString);
    }
    /**
     * 添加章节
     */
    @RequestMapping("/add")
    public void add(Chapter chapter, HttpServletRequest request, MultipartFile aaa) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();

        chapter.setUrl(path+"."+aaa.getOriginalFilename());

        chapterService.add(chapter);
    }
    /**
     * 删除章节
     */
    @RequestMapping("/delete")
    public void delete(String id){
        chapterService.delete(id);
       // return "/back/page/album/chapter/show.jsp";
    }

    /**
     * 修改章节
     */
    @RequestMapping("/update")
    public void update(Chapter chapter,HttpServletRequest request,MultipartFile aaa) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();

        chapter.setUrl(path+"."+aaa.getOriginalFilename());

        System.out.println("chaper"+chapter);
        chapterService.update(chapter);

        //return "/back/page/album/chapter/show.jsp";
    }
}
