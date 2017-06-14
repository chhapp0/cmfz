package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.SnowflakeIdWorker;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
    public void queryAll(HttpServletResponse response) throws IOException {
        List<Chapter> chapterList = chapterService.queryAll();
        String chapterString = JSONObject.toJSONString(chapterList);
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
    public String add(Chapter chapter, HttpServletRequest request, MultipartFile aaa) throws IOException {
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

        chapter.setUrl(realPath+"/img/"+newFileName);

        chapterService.add(chapter);
        return "/back/page/album/chapter/show.jsp";
    }
    /**
     * 删除章节
     */
    @RequestMapping("/delete")
    public String delete(String id){
        chapterService.delete(id);
        return "/back/page/album/chapter/show.jsp";
    }

    /**
     * 修改章节
     */
    @RequestMapping("/update")
    public String update(Chapter chapter){
        chapterService.update(chapter);
        return "/back/page/album/chapter/show.jsp";
    }
}
