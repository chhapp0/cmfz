package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Album;
import com.baizhi.entity.Moduleobject;
import com.baizhi.service.AlbumService;
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
import java.util.List;

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
    @RequestMapping("/queryAllAdd")
    @ResponseBody
    public void queryAllAdd(HttpServletResponse response) throws IOException {
        List<Album> albumList = albumService.queryAllAdd();
        String albumString = JSONObject.toJSONStringWithDateFormat(albumList, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(albumString);
    }


    /**
     * 添加专辑
     */
    @RequestMapping("/add")
    public void add(Album album, HttpServletRequest request, MultipartFile aaa) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();

        album.setThumbnail(path+"."+aaa.getOriginalFilename());
        albumService.add(album);
        //return "/back/page/album/info/show.jsp";
    }

    /**
     * 修改专辑
     */
    @RequestMapping("/update")
    public void update(Album album,MultipartFile aaa,HttpServletRequest request) throws IOException {

        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();

        album.setThumbnail(path+"."+aaa.getOriginalFilename());
        albumService.add(album);
        //return "/back/page/album/info/show.jsp";

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
