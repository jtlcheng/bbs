package com.cheng.service;

import com.cheng.pojo.user;
import org.apache.ibatis.annotations.Param;

public interface userInfo {
    user loginUserInfo(String uName);
    boolean registerUserInfo(user user);

    /**
     * 根据用户Id查看个人信息
     * @param uid 主键
     * @return
     */
    user personalInformationById(@Param( value = "uid") int uid);

    /**
     * 根据用户Id修改个人信息
     * @param uId 主键
     * @return
     */
    int updatePersonalInformationById(user user);
}

