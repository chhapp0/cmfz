package com.baizhi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ljf on 2017/6/20.
 */
@Controller
@RequestMapping("/user")
public class User {
    @RequestMapping("/login")
    public String login(String name,String password){
        System.out.println(name);
        System.out.println(password);
        /**根据用户名/密码认证用户，怎么认证
         * 在web 环境下，当配置shiroFitlerFactoryBean 并注入安全管理器后
         * 自动将安全管理器注入到安全工具类中
         *获取主体对象进行认证
         */
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(name,password));

        return "redirect:/index.jsp";
    }

    @RequestMapping("/test")
    public void test(){
        Object principal = SecurityUtils.getSubject().getPrincipal();
        System.out.println(principal);
    }

}
