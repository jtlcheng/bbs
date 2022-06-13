package com.cheng.service.user.impl;

import com.cheng.config.shiro.TokenGenerator;
import com.cheng.dao.userInfoDao;
import com.cheng.pojo.user;
import com.cheng.service.user.userInfo;
import com.cheng.util.JavaMail;
import com.cheng.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@Service
public class userInfoServiceImpl implements userInfo {

    @Resource
    JavaMail mail;
    @Autowired
    userInfoDao dao;

    @Override
    public user loginUserInfo(String uName) {
        return dao.loginUserInfo(uName);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean registerUserInfo(@RequestBody user user) throws MessagingException {
        user byUserName=dao.loginUserInfo(user.getUname());
        //判断用户是否存在
        if (byUserName!=null){
            //用户名存在，注册失败
            return false;
        }
        //保存用户信息
        //设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //设置激活状态
        user.setStatus("N");
        dao.registerUserInfo(user);
        String content="<a href='http://localhost:8081/userInfo/findByCode?code="+user.getCode()+"'>点击激活【论坛管理系统账号】</a>";
        mail.mail(true,user.getUemail(),content,"激活账号");
        return true;
    }

    @Override
    public user personalInformationById(int uid) {
        return dao.personalInformationById(uid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updatePersonalInformationById(@RequestBody user user) {
        return dao.updatePersonalInformationById(user);
    }


    @Override
    public boolean findByCode(String code) {
        //1.根据激活码查询用户对象
        user user= dao.findByCode(code);
        if (user!=null){
        //2.调用dao的修改激活状态的方法
            dao.updateStatus(user);
            return true;
        }else {
            return false;
        }

    }
}
