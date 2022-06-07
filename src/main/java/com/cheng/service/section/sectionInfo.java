package com.cheng.service.section;

import com.cheng.pojo.section;
import com.cheng.pojo.topic;

import java.util.List;

public interface sectionInfo {
    List<section> listAllSection();
    section listTopicBySectionId(int sId);
}
