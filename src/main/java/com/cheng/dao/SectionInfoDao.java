package com.cheng.dao;

import com.cheng.pojo.section;
import com.cheng.pojo.topic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SectionInfoDao {
    /**
     * 查询所有话题
     * @return
     */
    List<section> listAllSection();
    /**
     * 查询话题的id
     */
    section listTopicBySectionId(int sId);
}
