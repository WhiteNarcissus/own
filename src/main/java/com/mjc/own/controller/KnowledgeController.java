package com.mjc.own.controller;



import com.mjc.own.common.Code;
import com.mjc.own.common.DateUtil;
import com.mjc.own.common.ReturnObject;
import com.mjc.own.domain.Knowledge;
import com.mjc.own.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {
    @Autowired
    KnowledgeService knowledgeService ;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/save")
    public ReturnObject knowledgeSave(Knowledge knowledge) {
        ReturnObject<Knowledge> returnObject = new ReturnObject<Knowledge>();
        Knowledge  know = new Knowledge();
        know.setTitle(knowledge.getTitle());
        know.setContent(knowledge.getContent());
        know.setCreateTime(DateUtil.getTimestamp());
        //从缓存 获取当前对象stuId
        know.setStuId(stringRedisTemplate.opsForValue().get("CURRENT_USER"));
        knowledgeService.knowledgeSave(know);
        returnObject.setMsg("保存成功");
        returnObject.setCode(Code.SUCCESS);

        return returnObject;
    }

    @RequestMapping("/list")
    public ReturnObject<List<Knowledge>> knowledgeList (Knowledge knowledge){
        ReturnObject<List<Knowledge>> returnObject = new ReturnObject<List<Knowledge>>();
        List<Knowledge> data = knowledgeService.knowledgeList(knowledge);
        if (!data.isEmpty()){
            returnObject.setCode(Code.SUCCESS);
            returnObject.setRows(data);
            returnObject.setMsg("hhhh");
        }
        return returnObject ;
    }

    @RequestMapping("/delete")
    public ReturnObject<Knowledge> deleteKnowledge(String id,String stuId) throws  Exception{
        ReturnObject<Knowledge> knowledgeReturnObject = new ReturnObject<Knowledge>();
        knowledgeReturnObject.setCode(Code.SUCCESS);
        //如果不是本人的学号的话 则提示非本人不可删除
        String current = stringRedisTemplate.opsForValue().get("CURRENT_USER");
        if(null != current && !"".equals(current)){

            //如果是超管登入的话
            if("123456".equals(current)){
                knowledgeService.delete(id);
                knowledgeReturnObject.setMsg("删除成功！！！");
            }else {
                if(!current.equals(stuId)){
                    knowledgeReturnObject.setMsg("非本人 知识分享 不可删除");
                }else {
                    knowledgeService.delete(id);
                    knowledgeReturnObject.setMsg("删除成功！！！");
                }

            }
        }else{
            knowledgeReturnObject.setMsg("缓存出错！！！");
        }

        return knowledgeReturnObject;
    }
    @RequestMapping("/look")
    public ReturnObject<Knowledge> knowledgeLook (String id,String stuId){
        ReturnObject<Knowledge> returnObject = new ReturnObject<Knowledge>();
        Knowledge knowledge =  knowledgeService.knowledgeLook(id,stuId);
        returnObject.setCode(Code.SUCCESS);
        returnObject.setRows(knowledge);

        return returnObject ;
    }
}
