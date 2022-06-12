package com.cheng.service.section;

import com.cheng.pojo.section;
import com.cheng.pojo.topic;
import io.swagger.models.auth.In;

import java.util.List;

public interface sectionInfo {
    List<section> listAllSection();
    section listTopicBySectionId(int sId);
    boolean createASection(section section);
    boolean updateASection(section section);
    boolean deleteASectionBySid(Integer sId);
    List<section>querySectionByTopic(int sId);

}
