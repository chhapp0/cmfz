package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Choose;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by ljf on 2017/6/13.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    /**
     * 验证登录
     */

    @RequestMapping("/login")
    @ResponseBody
    public Choose login(Admin admin, HttpSession httpSession){
        Choose choose = new Choose(false);
            Admin admin1 = adminService.queryByName(admin);
            if(admin1!=null){
                httpSession.setAttribute("admin",admin);
                choose.setTemp(true);
                System.out.println(choose.isTemp());
                return choose;
            }else{
                return choose;
            }
    }
    /**
     * 管理员注册
     */
    public String add(Admin admin){
        adminService.add(admin);
        return "redirect:/back/login.jsp";
    }

}
