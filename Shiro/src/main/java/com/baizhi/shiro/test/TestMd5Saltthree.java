package com.baizhi.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;


/**
 * Created by ljf on 2017/6/19.
 */
public class TestMd5Saltthree {
    public static void main(String[] args) {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-md5-hash-salt-mutil.ini");

        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        Subject subject=SecurityUtils.getSubject();

        subject.login(new UsernamePasswordToken("zhangsan","123456"));
        System.out.println(subject.isAuthenticated());

    }
}
