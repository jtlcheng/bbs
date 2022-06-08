package com.cheng.service.reply.impl;

import com.cheng.dao.replyInfoDao;
import com.cheng.pojo.reply;
import com.cheng.service.reply.replyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class replyInfoServiceImpl implements replyInfo {
    @Autowired
    replyInfoDao dao;

    private static final Map<Integer,Integer> STATUS_MAP = new ConcurrentHashMap<>();
    /**
     * 举报：正常
     */
    private static final int STATUS_NORMAL = 0;
    /**
     * 举报：给管理员审核
     */
    private static final int STATUS_BLANK = 1;

    /**
     *  举报：管理员审核完毕
     */
    private static final int STATUS_END = 2;
    static {
        STATUS_MAP.put(0,STATUS_NORMAL);
        STATUS_MAP.put(1,STATUS_BLANK);
        STATUS_MAP.put(2,STATUS_END);
    }
    @Override
    public List<reply> listAllContent(int uid) {
        return dao.listAllContent(uid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addContent(reply reply) {
        return dao.addContent(reply)>0;
    }

    @Override
    public int updateStatue(int rid, int status) {

        return dao.updateStatue(rid,status);
    }

    @Override
    public int updateStatueEnd(int rid, int status) {
        return dao.updateStatueEnd(rid,status);
    }

    @Override
    public int updateStatueEndFail(int rid, int status) {
        return dao.updateStatueEndFail(rid,status);
    }

}
