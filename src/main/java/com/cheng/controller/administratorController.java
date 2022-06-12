package com.cheng.controller;

import com.cheng.pojo.section;
import com.cheng.service.section.sectionInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@Api("管理员功能")
public class administratorController {
    @Autowired
    sectionInfo info;

    @ApiOperation("创建话题功能")
    @PostMapping("createASection")
    public boolean createASection(@RequestBody section section){
        return info.createASection(section);
    }
    @ApiOperation("修改话题名字")
    @PostMapping("updateASection")
    public boolean updateASection(@RequestBody section section){
        return info.updateASection(section);
    }
    @ApiOperation("根据话题Id删除")
    @GetMapping("deleteASectionBySid/{sId}")
    public boolean deleteASectionBySid(@PathVariable("sId") Integer sId){
        return info.deleteASectionBySid(sId);
    }
    @ApiOperation("根据sId查询话题下的帖子")
    @GetMapping("querySectionByTopic")
    public List<section> querySectionByTopic(@RequestParam int sId){
        System.out.println(sId);
        return info.querySectionByTopic(sId);
    }
}
