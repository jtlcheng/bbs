package com.cheng.dao;

import com.cheng.pojo.user;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userInfoDao {
    user loginUserInfo(String uName);
    int registerUserInfo(user user);

    /**
     * 根据用户Id查看个人信息
     * @param uid 主键
     * @return
     */
    user personalInformationById(@Param(value = "uid") int uid);

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    int updatePersonalInformationById(user user);

}
