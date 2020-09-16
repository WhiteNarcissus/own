package com.mjc.own.service.impl;



import com.mjc.own.domain.Knowledge;
import com.mjc.own.mapper.KnowledgeMapper;
import com.mjc.own.service.KnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    KnowledgeMapper knowledgeMapper;

    @Override
    public void knowledgeSave(Knowledge knowledge) {
        knowledgeMapper.insert(knowledge);
    }

    @Override
    public List<Knowledge> knowledgeList(Knowledge knowledge) {
        List<Knowledge> knowledges ;
         if("".equals(knowledge.getStuId())&&"".equals(knowledge.getTitle())){
             Example example = new Example(Knowledge.class);
             example.createCriteria().andNotEqualTo("id",0);
             example.setOrderByClause("create_time DESC");
             knowledges =knowledgeMapper.selectByExample(example);
        }else {
            Example example = new Example(Knowledge.class);
            example.createCriteria().andEqualTo("stuId", knowledge.getStuId());
            example.createCriteria().andLike("title", knowledge.getTitle());
             example.setOrderByClause("create_time DESC");
             knowledges= knowledgeMapper.selectByExample(example);
        }
        return knowledges;
    }

    @Override
    public void delete(String id) {
        Example example = new Example(Knowledge.class);
        example.createCriteria().andEqualTo("id",Integer.parseInt(id));
        knowledgeMapper.deleteByExample(example);
    }

    @Override
    public Knowledge knowledgeLook(String id, String stuId) {
        Example example = new Example(Knowledge.class);
        example.createCriteria().andEqualTo("id",id);
        example.createCriteria().andEqualTo("stuId",stuId);
        if(!knowledgeMapper.selectByExample(example).isEmpty()){
            return knowledgeMapper.selectByExample(example).get(0);
        }

        return  null ;
    }
}
