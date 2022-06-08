package com.cheng.controller;

import com.cheng.pojo.reply;
import com.cheng.service.reply.replyInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reply")
public class replyInfoController {
    @Autowired
    replyInfo replyInfo;
    @ApiOperation("根据uId查询回复")
    @GetMapping("listAllContent/{uid}")
    public List<reply> listAllContent(@PathVariable("uid") int uid){
        return replyInfo.listAllContent(uid);
    }
    @ApiOperation("增加评论")
    @PostMapping("addContent")
    public boolean addContent(@RequestBody reply reply){
        return replyInfo.addContent(reply);
    }
    @ApiOperation("举报功能提交给管理员审核")
    @PostMapping("updateStatue")
    public boolean updateStatue(int rid,Integer status){
        return replyInfo.updateStatue(rid,1)>0;
    }
    @ApiOperation("举报功能管理员审核")
    @PostMapping("updateStatueEnd")
    public boolean updateStatueEnd(int rid,Integer status){
            return replyInfo.updateStatueEnd(rid,2)>0;
    }
    @ApiOperation("举报功能管理员审核不通过")
    @PostMapping("updateStatueEndFail")
    public boolean updateStatueEndFail(int rid,Integer status){
        return replyInfo.updateStatueEnd(rid,0)>0;
    }

}
