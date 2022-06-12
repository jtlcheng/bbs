package com.cheng.controller;

import com.cheng.pojo.section;
import com.cheng.service.section.sectionInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("section")
public class sectionInfoController {
    @Autowired
    sectionInfo sectionInfo;
    @ApiOperation("查询所有话题")
    @GetMapping("listAllSection")
    public List<section> listAllSection (){
        return sectionInfo.listAllSection();
    }
    @ApiOperation("查询话题Id")
    @GetMapping("listTopicBySectionId/{sId}")
    public section listTopicBySectionId(@PathVariable("sId") int sId){
        return sectionInfo.listTopicBySectionId(sId);
    }

}
