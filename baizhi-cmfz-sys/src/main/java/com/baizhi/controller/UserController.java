package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Moduleobject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public void queryAll(HttpServletResponse response,Integer page,Integer rows) throws IOException {
        Page<User> pages = userService.queryAll(page, rows);
        Moduleobject moduleobject=new Moduleobject();
        moduleobject.setRows(pages.getResult());
        moduleobject.setTotal(pages.getTotal());
        String userListString = JSONObject.toJSONString(pages);

        System.out.println(userListString+"contro用户啊");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(userListString);
    }

    @RequestMapping("/queryAllAdd")
    @ResponseBody
    public void queryAll(HttpServletResponse response) throws IOException {
        List<User> userList = userService.queryAllAdd();
        String userListString = JSONObject.toJSONString(userList);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(userListString);
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public void queryOne(HttpServletResponse response,String id) throws IOException {
        User user = userService.queryOne(id);
        String userString = JSONObject.toJSONString(user);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(userString);
    }
    @RequestMapping("/delete")
    public void delete(String id){
        userService.delete(id);
       // return "/back/page/user/info/show.jsp";
    }

    @RequestMapping("/add")
    public void add(User user, MultipartFile aaa, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();

        user.setPhoto(path+"."+aaa.getOriginalFilename());
        userService.add(user);
        //return "/back/page/user/info/show.jsp";
    }
    @RequestMapping("/update")
    public void update(User user, MultipartFile aaa, HttpServletRequest request,String id) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //创建一个新的文件夹
        File file=new File(realPath,"/img");
        if(!file.exists()){
            file.mkdirs();
        }
        String contextPath = request.getContextPath();
        aaa.transferTo(new File(file,aaa.getOriginalFilename()));
        String path=contextPath+"/img/"+aaa.getOriginalFilename();

        user.setPhoto(path+"."+aaa.getOriginalFilename());
        userService.update(user);
        //return "/back/page/user/info/show.jsp";
    }

}
