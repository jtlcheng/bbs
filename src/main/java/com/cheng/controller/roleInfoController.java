package com.cheng.controller;

import com.cheng.pojo.role;
import com.cheng.pojo.user;
import com.cheng.service.role.roleInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class roleInfoController {
    @Autowired
    roleInfo roleInfo;

    @ApiOperation("查看角色的权限")
    @PostMapping("findRole")
    public role findRole(Integer roleId) {
        return roleInfo.findRole(roleId);
    }
}
