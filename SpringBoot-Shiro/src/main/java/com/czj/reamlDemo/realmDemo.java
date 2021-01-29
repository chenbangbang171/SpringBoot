package com.czj.reamlDemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


public class realmDemo extends AuthorizingRealm {


    private String realmName  = "realmDemo";

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken
                                                                 authenticationToken) throws AuthenticationException {
        //从token中取出用户信息
        //用户名，身份信息
        String principal = (String)authenticationToken.getPrincipal();
        System.out.println(principal);
        //密码，凭证
        Object credentials = authenticationToken.getCredentials();
        //类型转化
        String password = new String((char[]) credentials);
        System.out.println(password);

        if("jack".equals(principal) && "123".equals(password)){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,password,realmName);

            return simpleAuthenticationInfo;
        }

        return null;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }



}
