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
     /*   //文件上传路径
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
        essay.s(realPath+"/img/"+newFileName);


        albumService.add(album);*/
    }
    @RequestMapping("/update")
    public void update(Essay essay){
        /*essayService.update(essay);
        //return "/back/page/essay/info/show.jsp";*/
    }
    @RequestMapping("/delte")
    public void delte(String id){
        essayService.delete(id);
        //return "/back/page/essay/info/show.jsp";
    }

}
