package com.baizhi.controller;

import com.baizhi.SnowflakeIdWorker;
import com.baizhi.service.AlbumService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/14.
 */
@Controller
@RequestMapping("/file")
public class uploadController {
    @Resource
    private AlbumService albumService;
    //接收文件参数定义为  multipartFile
    @RequestMapping("/upload")
    public String upload(MultipartFile aaa, HttpServletRequest request) throws IOException {
        //文件上传路径
        String realPath = request.getSession().getServletContext().getRealPath("/back");
        //获取父路径
        String parent = new File(realPath).getParent();
        File file=new File(parent,"upload");
        if(!file.exists()){
            file.mkdirs();
        }

        //生成一个新名字
        SnowflakeIdWorker idWorker=new SnowflakeIdWorker(0,0);
        String id = String.valueOf(idWorker.nextId());
        String newFileName =id+"."+ FilenameUtils.getExtension(aaa.getOriginalFilename());

        //直接上传文件
        aaa.transferTo(new File(file,newFileName));

        return "/back/";
    }
}
