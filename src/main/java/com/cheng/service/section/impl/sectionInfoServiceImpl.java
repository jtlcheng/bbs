package com.cheng.service.section.impl;

import com.cheng.dao.SectionInfoDao;
import com.cheng.pojo.section;
import com.cheng.service.section.sectionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public boolean createASection(section section) {
        return dao.createASection(section)>0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateASection(section section) {
        return dao.updateASection(section)>0;
    }

    @Override
    public boolean deleteASectionBySid(Integer sId) {
        return dao.deleteASectionBySid(sId)>0;
    }

    @Override
    public List<section> querySectionByTopic(int sId) {
        return dao.querySectionByTopic(sId);
    }

}
