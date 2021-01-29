package com.czj.reaml;

import com.czj.pojo.User;
import com.czj.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

public class ShiroReaml extends AuthorizingRealm {

    @Autowired
    @Lazy
    private  UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        System.out.println(username);
        //通过userName（用户账号是唯一的）查询数据库获取权限信息
        List<String> permissionList = userService.queryAllPermissionsByUserName(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

//        HashSet<String> permissions = new HashSet<>();
//        permissions.add("user:add");
////        permissions.add("user:update");
////        permissions.add("user:query");
//        permissions.add("user:delete");

        simpleAuthorizationInfo.addStringPermissions(permissionList);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String)token.getPrincipal();

        Object credentials = token.getCredentials();
        String password = new String((char[])credentials);

        System.out.println(principal + "------" + password);
        System.out.println(userService);
        User user = userService.queryUserByNameAndPwd(principal, password);

        if(user != null){
            System.out.println("------simpleAuthenticationInfo------");
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,password,"");
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
