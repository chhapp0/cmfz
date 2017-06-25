package com.baizhi.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by ljf on 2017/6/20.
 */
public class TestPerssion {

    public static void main(String[] args) {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-perssion.ini");

        SecurityManager instance = iniSecurityManagerFactory.getInstance();

        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();

        subject.login(new UsernamePasswordToken("lisi","123456"));
        //授权
    /*    if(subject.isAuthenticated()){
            //基于角色访问控制
            boolean role1 = subject.hasRole("role1");
            System.out.println(role1);

            //同时拥有两个角色
            boolean hasAllRoles = subject.hasAllRoles(Arrays.asList("role1", "role3"));
            System.out.println(hasAllRoles);

            //分别具有哪些角色
            boolean[] hasRoles = subject.hasRoles(Arrays.asList("role1", "role3"));
            for (boolean b:hasRoles
                 ) {
                System.out.print(b+",");
            }
        }*/
    //基于资源的访问控制
        boolean permitted = subject.isPermitted("product:findAll:001");
        System.out.println(permitted);

        //同时具有哪些权限
        boolean permitted1 = subject.isPermittedAll("product:findAll", "user:delete:003", "user:update", "product:add");
        System.out.println(permitted1);

        //分别具有哪些权限字符串
        boolean[] permitted2 = subject.isPermitted("product:findAll", "user:delete:003", "user:update", "product:add");
        for (boolean b:permitted2
             ) {
            System.out.print(b+",");
        }
    }
}
