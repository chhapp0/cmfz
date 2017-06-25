package com.baizhi.shiro.realm;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Permission;
import com.baizhi.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ljf on 2017/6/20.
 */
public class AdminRealm extends AuthorizingRealm{
    @Resource
    private AdminService adminService;
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username=String.valueOf(principals.getPrimaryPrincipal());

        System.out.println(username);
        System.out.println("----------"+principals.getPrimaryPrincipal());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Admin admin = adminService.queryByUserName(username);

        simpleAuthorizationInfo.addRole(admin.getRole().getRole());

        List<Permission> permissions = admin.getRole().getPermissions();
        for (Permission p: permissions
             ) {
            String per=p.getPermission();
            simpleAuthorizationInfo.addStringPermission(per);
        }
        return simpleAuthorizationInfo;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("用户名是"+token.getPrincipal());
        String username=String.valueOf(token.getPrincipal());
        Admin admin = adminService.queryByUserName(username);
        System.out.println("12$@^$#$!$!@$!@$"+admin);
        String password = admin.getPassword();
        String salt = admin.getSalt();
        if(admin!=null){
            return new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(salt),this.getName());
        }
        return null;
    }
}
