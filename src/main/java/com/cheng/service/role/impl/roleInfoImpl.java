package com.cheng.service.role.impl;

import com.cheng.dao.RoleInfoDao;
import com.cheng.pojo.role;
import com.cheng.pojo.user;
import com.cheng.service.role.roleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class roleInfoImpl implements roleInfo {
    @Autowired
    RoleInfoDao dao;
    @Override
    public role findRole(Integer roleId) {
        return dao.findRole(roleId);
    }
}
