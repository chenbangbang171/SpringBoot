package com.czj;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Test;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBootShrioApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public  void testLoginAndLogOut(){
        //创建SecurityManager工厂，用过ini配置文件创建SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classPath:shiro.ini");

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

        //退出操作
        subject.logout();

      authenticated = subject.isAuthenticated();

      System.out.println("是否认证通过"+ authenticated);
    }

}
