package com.cheng.controller;

import com.cheng.pojo.user;
import com.cheng.service.userInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("userInfo")
public class userInfoController {
    @Autowired
    userInfo userInfo;
    @RequestMapping({"/","index"})
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/loginUserInfo")
    public String loginUserInfo(String uName, String uPassword, Model model) {
        //获取当前的用户
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(uName, uPassword);
        try {
            subject.login(token);//执行登录方法，如果没有异常就说明OK了
            return "index";
        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){//密码错误
            model.addAttribute("msg","密码错误");
            return  "login";
        }
    }
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
