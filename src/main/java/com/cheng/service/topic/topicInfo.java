package com.cheng.service.topic;


import com.cheng.pojo.section;
import com.cheng.pojo.topic;

import java.util.List;

public interface topicInfo {
    List<topic> SearchForPosts(String sName);
    List<topic> browseThePost(topic topic);
    boolean postAMessage(topic topic);
    topic checkTheLikes(Integer tid);

}
