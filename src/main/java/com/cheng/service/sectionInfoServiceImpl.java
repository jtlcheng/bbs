package com.cheng.service;

import com.cheng.dao.SectionInfoDao;
import com.cheng.pojo.section;
import com.cheng.pojo.topic;
import com.cheng.service.section.sectionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sectionInfoServiceImpl implements sectionInfo {
    @Autowired
    SectionInfoDao dao;
    @Override
    public List<section> listAllSection() {
        return dao.listAllSection();
    }
    @Override
    public section listTopicBySectionId(int sId) {
        return dao.listTopicBySectionId(sId);
    }
}
