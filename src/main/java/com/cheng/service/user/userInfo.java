package com.cheng.service.user;

import com.cheng.pojo.user;
import org.apache.ibatis.annotations.Param;

import javax.mail.MessagingException;
import java.util.Map;

public interface userInfo {
    user loginUserInfo(String uName);
    boolean registerUserInfo(user user) throws MessagingException;

    /**
     * 根据用户Id查看个人信息
     * @param uid 主键
     * @return
     */
    user personalInformationById(@Param( value = "uid") int uid);

    /**
     * 根据用户Id修改个人信息
     * @param user
     * @return
     */
    int updatePersonalInformationById(user user);



    /**
     * 根据激活码查询对象
     * @param code
     * @return
     */
    boolean findByCode(String code);


}

