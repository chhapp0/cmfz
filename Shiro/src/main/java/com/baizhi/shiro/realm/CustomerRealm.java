package com.baizhi.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by ljf on 2017/6/20.
 */
public class CustomerRealm  extends AuthorizingRealm{
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if("zhangsan".equals("用户名==:"+token.getPrincipal())){
            return new SimpleAuthenticationInfo("zhangsan","a042c4d4dfa38f0ba863ddaea1065e0c", ByteSource.Util.bytes("*9sj"),this.getName());
        }
        return null;
    }
}
