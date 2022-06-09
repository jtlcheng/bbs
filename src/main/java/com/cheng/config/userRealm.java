package com.cheng.config;


import com.cheng.pojo.user;
import com.cheng.service.user.userInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的UserRealm
public class userRealm extends AuthorizingRealm {
    @Autowired
    userInfo userInfo;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        //添加授权类
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加授权认证
//        info.addStringPermission("user:add");
//        info.addStringPermission("user:update");
        //拿到当前登录的这个对象
        Subject subject= SecurityUtils.getSubject();
        user current = (user) subject.getPrincipal();//拿到User对象
        //设置当前用户的权限
        info.addStringPermission(current.getPerms());

        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthorizationInfo");

        UsernamePasswordToken userToken=(UsernamePasswordToken) token;
        //获取真实的数据库密码
        user user = userInfo.loginUserInfo(userToken.getUsername());
      

        /*Subject currentSubject=SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);*/
        //可以加密 MD5:b68dfe15c36592af941c8758f574f267 MD5盐值加密:b68dfe15c36592af941c8758f574f267username
        //密码认证，shiro 做
        return new SimpleAuthenticationInfo(user,user.getUpwd(),"");
    }
}
