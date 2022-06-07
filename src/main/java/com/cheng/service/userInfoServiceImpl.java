package com.cheng.service;

import com.cheng.dao.userInfoDao;
import com.cheng.pojo.user;
import com.cheng.service.user.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class userInfoServiceImpl implements userInfo {
    @Autowired
    userInfoDao dao;
    @Override
    public user loginUserInfo(String uName) {
        return dao.loginUserInfo(uName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean registerUserInfo(@RequestBody user user) {
        return dao.registerUserInfo(user)>0;
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
}
