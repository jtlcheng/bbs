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
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            result.put("token",token);
        }
        return result;
    }

    //注销
    @PostMapping("logout")
    @ResponseBody
    public boolean logout(){
        SecurityUtils.getSubject().logout();
        return true;
    }
    //注册    
    @PostMapping("registerUserInfo")
    @ResponseBody
    public boolean registerUserInfo(@RequestBody user user) throws MessagingException {
        System.out.println(user);
        return userInfo.registerUserInfo(user);
    }
    @RequestMapping("findByCode")
    public void findByCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code=request.getParameter("code");
        if (code!=null){
            boolean flag=userInfo.findByCode(code);

            //3.判断标记
            String msg = null;
            if (flag) {
                //激活成功
                msg = "激活成功，请<a href='/login.html'>登录</a>";
            } else {
                //激活失败
                msg = "激活失败，请联系管理员！";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
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
