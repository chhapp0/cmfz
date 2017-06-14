package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.SnowflakeIdWorker;
import com.baizhi.entity.Album;
import com.baizhi.entity.Moduleobject;
import com.baizhi.service.AlbumService;
import com.github.pagehelper.Page;
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

/**
 * Created by ljf on 2017/6/13.
 */

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    /**
     * 查找所有专辑
     * @param response
     * @throws IOException
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response,Integer page, Integer rows) throws IOException {
        Page<Album> pages = albumService.queryAll(page, rows);
        Moduleobject moduleobject = new Moduleobject();
        moduleobject.setRows(pages.getResult());
        moduleobject.setTotal(pages.getTotal());

        String albumString = JSONObject.toJSONStringWithDateFormat(moduleobject, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(albumString);
    }
    /**
     * 查一个专辑
     */
    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(String id,HttpServletResponse response) throws IOException {
        System.out.println(id);
        Album album = albumService.queryOne(id);

        System.out.println(album);
        String albumString = JSONObject.toJSONStringWithDateFormat(album, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(albumString);
    }


    /**
     * 添加专辑
     */
    @RequestMapping("/add")
    public void add(Album album, HttpServletRequest request, MultipartFile aaa) throws IOException {
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
        album.setThumbnail(realPath+"/img/"+newFileName);


        albumService.add(album);
    }

    /**
     * 修改专辑
     */
    @RequestMapping("/update")
    public void update(Album album,MultipartFile aaa,HttpServletRequest request) throws IOException {

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
        album.setThumbnail(realPath+"/img/"+newFileName);

        albumService.update(album);
       //return "redirect:/back/page/album/info/edit.jsp";
    }

    /**
     * 删除一个专辑
     */
    @RequestMapping("/delete")
    public void delete(String id){
        System.out.println(id+"sdasdsadasd");
        albumService.delete(id);
        //return "redirect:/back/page/album/info/edit.jsp";
    }
}
