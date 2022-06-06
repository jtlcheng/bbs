package com.cheng.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
            anon:无需认证就可以访问
            authc:必须认证了才能访问
            User:必须拥有记住我功能 才能用
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
        /*filterMap.put("/User/addUser","authc");
        filterMap.put("/User/updateUser","authc");*/
        //授权
//        filterMap.put("/user/addUser","perms[user:add]");
        filterMap.put("/user/addUser","perms[user:add]");
        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        //设置未授权请求
        bean.setUnauthorizedUrl("/unauthorized");
        return bean;

    }

    //DefaultWebSecurityManger:第二步
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") userRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;

    }


    //创建realm对象 需要自定义类:第一步
    @Bean
    public userRealm userRealm(){
        userRealm userRealm=new userRealm();

        return userRealm;
    }
   /* //实现MD5加密
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        return hashedCredentialsMatcher;
    }*/

}
