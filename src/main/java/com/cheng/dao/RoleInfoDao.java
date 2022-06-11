package com.cheng.dao;

import com.cheng.pojo.role;
import com.cheng.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleInfoDao {
    role findRole(Integer roleId);
}
