package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Moduleobject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void add(User user){
        userService.add(user);
        //return "/back/page/user/info/show.jsp";
    }
    @RequestMapping("/update")
    public void update(User user){
        userService.update(user);
        //return "/back/page/user/info/show.jsp";
    }

}