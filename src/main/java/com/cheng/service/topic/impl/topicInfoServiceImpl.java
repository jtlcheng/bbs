package com.cheng.service.topic.impl;

import com.cheng.dao.TopicInfoDao;

import com.cheng.pojo.topic;
import com.cheng.service.topic.topicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class topicInfoServiceImpl implements topicInfo {
    @Autowired
    TopicInfoDao dao;
    @Override
    public List<topic> SearchForPosts(String sName) {
        return dao.SearchForPosts(sName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.SERIALIZABLE)
    public List<topic> browseThePost(topic topic) {
        return dao.browseThePost(topic);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean postAMessage(topic topic) {
        return dao.postAMessage(topic)>0;
    }

    @Override
    public topic checkTheLikes(Integer tid) {
        return dao.checkTheLikes(tid);
    }


}
