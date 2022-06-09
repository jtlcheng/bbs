package com.cheng.controller;

import com.cheng.pojo.dto.LoginDTO;
import com.cheng.pojo.user;
import com.cheng.service.user.userInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("userInfo")
public class userInfoController {
    @Autowired
    userInfo userInfo;

    @PostMapping("login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody LoginDTO loginDTO, BindingResult bindingResult){
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        //用户信息
        user user = userInfo.loginUserInfo(username);
        //账号不存在、密码错误
        if (user == null || !user.getUpwd().equals(password)) {
            result.put("status", 400);
            result.put("msg", "账号或密码有误");
        } else {
            //生成token，并保存到数据库
            Subject subject = SecurityUtils.getSubject();
            //封装用户的登陆数据
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            subject.login(token);
            result.put("status", 200);
            result.put("msg", "登陆成功");
        }
        return result;
    }

   /* //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //记住我功能
        token.setRememberMe(true);
        try {
            subject.login(token);//执行登录方法，如果没有异常就说明OK了


            Subject currentSubject=SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            session.setAttribute("loginUser",subject);

        }catch (UnknownAccountException e){//用户名不存在
            return null;
        }catch (IncorrectCredentialsException e){//密码错误
            return null;
        }

    }*/
    //注销
    @GetMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }
    //注册    
    @PostMapping("/register")
    @ResponseBody
    public boolean registerUserInfo(@RequestBody user user){
        System.out.println(user);
        return userInfo.registerUserInfo(user);

    }
    @ApiOperation("查看个人信息")
    @GetMapping("personalInformationById/{uid}")
    @ResponseBody
    public user personalInformationById(@PathVariable("uid") int uid){
        return userInfo.personalInformationById(uid);
    }
    @ApiOperation("修改个人信息")
    @PostMapping("updatePersonalInformationById")
    @ResponseBody
    public int updatePersonalInformationById(@RequestBody user user){

        return userInfo.updatePersonalInformationById(user);
    }
}
