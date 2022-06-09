package com.cheng.controller;


import com.cheng.pojo.topic;
import com.cheng.service.topic.topicInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topic")
public class topicInfoController {
    @Autowired
    topicInfo topicInfo;


    @ApiOperation("根据帖子主题搜索")
    @GetMapping("searchForPosts")
    public List<topic> SearchForPosts(String sName){
        return topicInfo.SearchForPosts(sName);
    }
    @ApiOperation("浏览帖子")
    @GetMapping("browseThePost")
    public List<topic> browseThePost(){
        return topicInfo.browseThePost(null);
    }
    @ApiOperation("发帖子")
    @PostMapping("postAMessage")
    public boolean  postAMessage(@RequestBody topic topic){
        System.out.println(topic);
        return topicInfo.postAMessage(topic);
    }
    @ApiOperation("查看文章的点赞数量")
    @GetMapping("checkTheLikes/{tid}")
    public topic checkTheLikes(@PathVariable("tid") Integer tid){
        return topicInfo.checkTheLikes(tid);
    }
    @ApiOperation("点赞+1")
    @PostMapping("giveALike")
    public boolean giveALike(int uid,int tid){
        return topicInfo.giveALike(uid,tid)>0;
    }
    @ApiOperation("点赞-1")
    @PostMapping("giveALike_1")
    public boolean giveALike_1(int uid,int tid){
        return topicInfo.giveALike_1(uid,tid)>0;
    }
}
