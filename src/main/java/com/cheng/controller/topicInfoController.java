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
}
