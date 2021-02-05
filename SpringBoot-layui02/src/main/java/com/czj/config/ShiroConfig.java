package com.czj.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.czj.reaml.ShiroReaml;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.apache.shiro.mgt.SecurityManager;

import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public CookieRememberMeManager getCookieRememberMeManager(){

        SimpleCookie simpleCookie = new SimpleCookie("renemberMe");
        simpleCookie.setMaxAge(3600*24*31);

        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(simpleCookie);

        return cookieRememberMeManager;
    }

//    @Bean
//    public ShiroReaml getShiroReaml(){
//        ShiroReaml shiroReaml = new ShiroReaml();
//        shiroReaml.setCredentialsMatcher(CredentialsMatcher());
//
//        shiroReaml.setAuthenticationCachingEnabled(true);
//
//        shiroReaml.setAuthorizationCachingEnabled(true);
//        return  shiroReaml;
//    }

    @Bean
    public ShiroReaml getShiroReaml(){
        return  new ShiroReaml();
    }

    //安全管理对象
    @Bean
    @Qualifier
    public SecurityManager getSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getShiroReaml());
        return securityManager;
    }

    //配置ShiroDialect
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    //shiro过滤器配置
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //未认证访问的页面
        shiroFilterFactoryBean.setLoginUrl("/user/login3");

        //认证成功跳转的页面

        //未授权访问页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/refuse");
        //通过map配置访问流程（顺序很重要）
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //配置静态资源
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        map.put("/jquery/**","anon");
        map.put("/layui/**","anon");
        //配置login页面
        map.put("/user/userLogin","anon");

        //配置退出
        map.put("/logout","logout");

        map.put("/user/add","perms[user:add]");
        map.put("/user/query","perms[user:query]");
        map.put("/user/update","perms[user:update]");
        map.put("/user/delete","perms[user:delete]");

        //其他页面需要认证才能访问
        map.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

}
