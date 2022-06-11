package com.cheng.dao;

import com.cheng.pojo.section;
import com.cheng.pojo.topic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TopicInfoDao {
     /**
      * 根据帖子主题搜索
      * @param sName
      * @return
      */
     List<topic> SearchForPosts(String sName);

     /**
      * 浏览帖子
      * @return
      */
     List<topic> browseThePost(topic topic);
     /**
      * 发帖子
      */
     int postAMessage(topic topic);

     /**
      * 查看文章的点赞数量
      * @param tid
      * @return
      */
     topic checkTheLikes(Integer tid);

     /**
      * 点赞加一
      * @param uid
      * @param tid
      * @return
      */
     int giveALike(int uid,int tid);

     /**
      * 点赞减一
      * @param uid
      * @param tid
      * @return
      */
     int giveALike_1(int uid,int tid);
}
