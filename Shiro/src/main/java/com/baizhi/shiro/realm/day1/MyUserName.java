package com.baizhi.shiro.realm.day1;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * Created by ljf on 2017/6/19.
 */
public class MyUserName extends AuthenticatingRealm {
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户身份信息
        System.out.println("userName"+token.getPrincipal());
        //根据用户名查询sql
        if("zhangsan".equals(token.getPrincipal())){
           return new SimpleAuthenticationInfo("zhangsan","294871161d4de259bd3c86e3aaab27c7", ByteSource.Util.bytes("O9XZ"),this.getName());
        }
        return null;
    }
}
