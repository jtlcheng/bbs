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

    /**
     * 创建话题功能 管理员
     * @param section
     * @return
     */
    int createASection(section section);

    /**
     * 修改话题名字 管理员
     * @param section
     * @return
     */
    int updateASection(section section);

    /**
     * 根据Id删除话题
     * @param sId
     * @return
     */
    int deleteASectionBySid(Integer sId);

    /**
     * 查询话题下的帖子
     * @param sId
     * @return
     */
    List<section> querySectionByTopic(int sId);
}
