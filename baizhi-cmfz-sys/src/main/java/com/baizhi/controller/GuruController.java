package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.SnowflakeIdWorker;
import com.baizhi.entity.Guru;
import com.baizhi.entity.Moduleobject;
import com.baizhi.service.GuruService;
import com.github.pagehelper.Page;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/14.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response,Integer page, Integer rows) throws IOException {
        Page<Guru> pages = guruService.queryAll(page, rows);
        Moduleobject moduleobject = new Moduleobject();
        moduleobject.setRows(pages.getResult());
        moduleobject.setTotal(pages.getTotal());
        String guruString = JSONObject.toJSONStringWithDateFormat(moduleobject, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(guruString);
    }
    /**
     * 查一个专辑
     */
    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(String id,HttpServletResponse response) throws IOException {
        System.out.println(id);
        Guru guru = guruService.queryOne(id);

        System.out.println(guru);
        String guruString = JSONObject.toJSONStringWithDateFormat(guru, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(guruString);
    }


    /**
     * 添加专辑
     */
    @RequestMapping("/add")
    public void add(Guru guru, HttpServletRequest request, MultipartFile aaa) throws IOException {
        //文件上传路径
        String realPath = request.getSession().getServletContext().getRealPath("/");

        File file = new File(realPath, "/img");
        if(!file.exists()){
            file.mkdirs();
        }
        //生成一个新名字
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        String newFileName =id+"."+ FilenameUtils.getExtension(aaa.getOriginalFilename());


        aaa.transferTo(new File(file,newFileName));
        guru.setHead(realPath+"/img/"+newFileName);


        guruService.add(guru);
    }

    /**
     * 修改专辑
     */
    @RequestMapping("/update")
    public void update(Guru guru,MultipartFile aaa,HttpServletRequest request) throws IOException {

        //文件上传路径
        String realPath = request.getSession().getServletContext().getRealPath("/");

        File file = new File(realPath, "/img");
        if(!file.exists()){
            file.mkdirs();
        }
        //生成一个新名字
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        String newFileName =id+"."+ FilenameUtils.getExtension(aaa.getOriginalFilename());


        aaa.transferTo(new File(file,newFileName));
        guru.setHead(realPath+"/img/"+newFileName);

        guruService.update(guru);
        //return "redirect:/back/page/guru/info/edit.jsp";
    }

    /**
     * 删除一个专辑
     */
    @RequestMapping("/delete")
    public void delete(String id){
        System.out.println(id+"sdasdsadasd");
        guruService.delete(id);
        //return "redirect:/back/page/guru/info/edit.jsp";
    }
    
    
}
