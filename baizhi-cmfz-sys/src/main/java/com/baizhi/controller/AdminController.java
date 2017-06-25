package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
    public String login(Admin admin){
       // Choose choose = new Choose(false);
            /*Admin admin1 = adminService.queryByName(admin);*/
           /* if(admin1!=null){
                httpSession.setAttribute("admin",admin);
                choose.setTemp(true);
                System.out.println(choose.isTemp());
                return choose;
            }else{
                return choose;
            }*/
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(admin.getUsername(),admin.getPassword()));

        } catch (UnknownAccountException e) {
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }
        return "redirect:/back/page/main/main.jsp";
    }
    /**
     * 管理员注册
     */
    public String add(Admin admin){
        adminService.add(admin);
        return "redirect:/back/login.jsp";
    }

}
