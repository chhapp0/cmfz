package com.baizhi.controller;

import com.baizhi.entity.Iphone;
import com.baizhi.service.IphoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ljf on 2017/6/22.
 */
@Controller
@RequestMapping("/iphone")
public class IphoneController {
    @Resource
    private IphoneService iphoneService;

    @RequestMapping("/add")
    public String insert(HttpServletRequest request, Iphone iphone, MultipartFile aaa) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();
        iphone.setHref(path);
        iphoneService.insert(iphone);
        return "forward:/iphone/selectAll";
    }

    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request) throws IOException {
        List<Iphone> iphoneList = iphoneService.selectAll();
        request.setAttribute("iphones",iphoneList);
        return "forward:/iphone/showAll.jsp";
    }

    @RequestMapping("/selectOne")
    public String selectOne(String id,HttpServletRequest request){
        Iphone iphone = iphoneService.selectOne(id);
        request.setAttribute("iphone",iphone);
        return "forward:/iphone/showDetil.jsp";
    }
}
