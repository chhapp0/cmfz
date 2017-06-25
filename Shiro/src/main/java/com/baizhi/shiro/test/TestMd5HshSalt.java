package com.baizhi.shiro.test;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by ljf on 2017/6/19.
 */
public class TestMd5HshSalt {
    public static void main(String[] args) {
     /*   //md5算法
       *//* Md5Hash md5Hash=new Md5Hash("09XZ12345");
        System.out.println(md5Hash.toHex());*//*

        *//**
         * md5hash 散列
         * 明文: 123456
         * 散列: 2048
         * 0eb4d6a7d7bf61ad04734e2d0b8812d1
         *//*
        Md5Hash md5Hash = new Md5Hash("123456", null, 2048);
        System.out.println(md5Hash.toHex());

        *//**
         * md5hash salt散列
         * 明文:123456
         * salt: O9XZ
         * 散列次数: 2048
         * 结果:294871161d4de259bd3c86e3aaab27c7
         *//*
      /*  Md5Hash md5Hash1 = new Md5Hash("123456", "O9XZ", 2048);
        System.out.println(md5Hash1.toHex());*//*
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-md5-hash-salt-realm.ini");
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        Subject subject=SecurityUtils.getSubject();*/
        Md5Hash md5Hash = new Md5Hash("123456","fPHi", 1);
        //a042c4d4dfa38f0ba863ddaea1065e0c
        System.out.println(md5Hash.toHex());



    }
}