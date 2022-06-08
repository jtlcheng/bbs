package com.cheng.dao;

import com.cheng.pojo.reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface replyInfoDao {
    /**
     *
     * 根据uid查询所有评论
     * @return
     */
    List<reply> listAllContent(int uid);

    /**
     * 增加评论
     * @param reply
     * @return
     */
    int addContent(reply reply);

    /**
     *举报功能提交给管理员审核
     * @param rid
     * @param status
     * @return
     */
    int updateStatue(@Param("rid") int rid,@Param("status") int status);

    /**
     * 举报功能管理员审核
     * @param rid
     * @param status
     * @return
     */
    int updateStatueEnd(@Param("rid")int rid,@Param("status") int status);

    /**
     * 举报功能管理员审核不通过
     * @param rid
     * @param status
     * @return
     */
    int updateStatueEndFail(@Param("rid")int rid,@Param("status") int status);


}
