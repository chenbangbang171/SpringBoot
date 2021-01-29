package com.czj.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;


public class AuthenticationDemo {

    @Test
    public  void testLoginAndLogOut(){
        //创建SecurityManager工厂，用过ini配置文件创建SecurityManager工厂
        // 创建securityManager工厂，通过ini配置文件创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-permission.ini");

        //创建SecurityManager
        SecurityManager securityManager = factory.getInstance();

        //将SecurityManager设置到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);

        //从SecurityUtils中创建一个subject
        Subject subject = SecurityUtils.getSubject();

        //在认证提交前准备token（令牌）
        //这里的账号和密码，将来是由用户输入的
        UsernamePasswordToken token = new UsernamePasswordToken("jack", "123");

        subject.login(token);

        //是否认证通过
        boolean authenticated = subject.isAuthenticated();

        System.out.println("是否认证通过"+ authenticated);

        boolean role1 = subject.hasRole("role1");
        System.out.println("role1:" + role1);

        boolean allRoles = subject.hasAllRoles(Arrays.asList("role1", "role2"));
        System.out.println("role1 + role2："+allRoles);


        boolean permitted = subject.isPermitted("user:create");
        System.out.println("user:create:" + permitted);

        //退出操作
        subject.logout();

        authenticated = subject.isAuthenticated();

        System.out.println("是否认证通过"+ authenticated);
    }

    // 自定义realm
    @Test
    public void testRealmDemo() {

        // 创建securityManager工厂，通过ini配置文件创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        // 创建SecurityManager
        SecurityManager securityManager = factory.getInstance();

        // 将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);

        // 从SecurityUtils里边创建一个subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备token（令牌）
        // 这里的账号和密码 将来是由用户输入进去
        UsernamePasswordToken token = new UsernamePasswordToken("jack", "123");

        try {
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        // 是否认证通过
        boolean isAuthenticated = subject.isAuthenticated();

        System.out.println("是否认证通过：" + isAuthenticated);
    }
}
