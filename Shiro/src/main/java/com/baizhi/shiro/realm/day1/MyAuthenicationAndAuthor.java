package com.baizhi.shiro.realm.day1;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ljf on 2017/6/19.
 */
public class MyAuthenicationAndAuthor extends AuthorizingRealm{


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户的主身份信息
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        System.out.println("========"+primaryPrincipal);

        //根据用户名获取当前主体 角色和权限信息
        List<String> roles = Arrays.asList("role1", "role2");
        List<String> permissions = Arrays.asList("user:*", "product:update:01", "category:findAll");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        simpleAuthorizationInfo.addRoles(roles);

        return simpleAuthorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户身份信息
        System.out.println("获取用户身份信息:"+token.getPrincipal());
        if("zhangsan".equals(token.getPrincipal())){
            return new SimpleAuthenticationInfo("zhangsan","294871161d4de259bd3c86e3aaab27c7", ByteSource.Util.bytes("O9XZ"),this.getName());
        }
        return null;
    }
}
