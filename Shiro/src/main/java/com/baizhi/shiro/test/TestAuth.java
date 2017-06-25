package com.baizhi.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * Created by ljf on 2017/6/19.
 */
public class TestAuth {
    public static void main(String[] args) {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:authentication-authorization.ini");
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        Subject subject=SecurityUtils.getSubject();

        subject.login(new UsernamePasswordToken("zhangsan","123456"));

        if(subject.isAuthenticated()){
            System.out.println(subject.hasRole("role2"));
            System.out.println(subject.hasAllRoles(Arrays.asList("role1","role2")));
            System.out.println(subject.isPermitted("product:update"));
        }
    }
}
