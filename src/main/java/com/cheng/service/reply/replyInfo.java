package com.cheng.service.reply;

import com.cheng.pojo.reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface replyInfo {
    List<reply> listAllContent(int uid);
    boolean addContent(reply reply);
    int updateStatue(int rid,int status);
    int updateStatueEnd(int rid,int status);
    int updateStatueEndFail(int rid,int status);
}
