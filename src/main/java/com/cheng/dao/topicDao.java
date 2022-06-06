package com.cheng.dao;

import com.cheng.pojo.topic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface topicDao {
     topic SearchForPosts(topic topic);
}
