package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
    public void queryAll(HttpServletResponse response) throws IOException {
        List<Album> albumList = albumService.queryAll();
        String albumString = JSONObject.toJSONStringWithDateFormat(albumList, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(albumString);
    }
    /**
     * 查一个专辑
     */
    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(String id,HttpServletResponse response) throws IOException {
        Album album = albumService.queryOne(id);
        String albumString = JSONObject.toJSONStringWithDateFormat(album, "yyyy-MM-dd");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(albumString);
    }


    /**
     * 添加专辑
     */
    @RequestMapping("/add")
    public String add(Album album){
        albumService.add(album);
        return "redirect:/back/page/album/info/show.jsp";
    }

    /**
     * 修改专辑
     */
    @RequestMapping("/update")
    public String update(Album album){
        albumService.update(album);
        return "redirect:/back/page/album/info/edit.jsp";
    }

    /**
     * 删除一个专辑
     */
    @RequestMapping("/delete")
    public String delete(String id){
        albumService.delete(id);
        return "redirect:/back/page/album/info/edit.jsp";
    }
}
