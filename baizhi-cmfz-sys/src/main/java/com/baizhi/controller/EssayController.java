package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Essay;
import com.baizhi.entity.Moduleobject;
import com.baizhi.service.EssayService;
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
@RequestMapping("/essay")
public class EssayController {
    @Resource
    private EssayService essayService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response,Integer page,Integer rows) throws IOException {
        Page<Essay> pages = essayService.queryAll(page, rows);
        Moduleobject moduleobject=new Moduleobject();
        moduleobject.setRows(pages.getResult());
        moduleobject.setTotal(pages.getTotal());
        String essayListString = JSONObject.toJSONStringWithDateFormat(moduleobject, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(essayListString);
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(HttpServletResponse response,String id) throws IOException {
        Essay essay = essayService.queryOne(id);
        String essayString = JSONObject.toJSONStringWithDateFormat(essay, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(essayString);
    }

    @RequestMapping("/add")
    public void add(Essay essay, HttpServletRequest request, MultipartFile aaa) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/ess");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/ess/"+aaa.getOriginalFilename();

        essay.setLink(path+"."+aaa.getOriginalFilename());
        essayService.add(essay);
    }
    @RequestMapping("/update")
    public void update(Essay essay, HttpServletRequest request, MultipartFile aaa) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/ess");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/ess/"+aaa.getOriginalFilename();

        essay.setLink(path+"."+aaa.getOriginalFilename());
        essayService.update(essay);
    }
    @RequestMapping("/delte")
    public void delte(String id){
        essayService.delete(id);
        //return "/back/page/essay/info/show.jsp";
    }

}
