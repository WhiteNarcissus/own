package com.mjc.own.service;


import com.mjc.own.domain.Knowledge;

import java.util.List;

public interface KnowledgeService {
    /**
     * 保存一条 知识分享记录到数据库里去
     * @param knowledge
     * @return
     */
    void knowledgeSave(Knowledge knowledge);


    /**
     * 查询知识分享列表
     * @return
     */
    List<Knowledge> knowledgeList (Knowledge knowledge);

    void delete(String id);

    Knowledge knowledgeLook(String id ,String stuId);

}
