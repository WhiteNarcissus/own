package com.example.help.controller;

import com.example.help.common.Code;
import com.example.help.common.DateUtil;
import com.example.help.common.ReturnObject;
import com.example.help.domain.*;
import com.example.help.mapper.SecondhandMapper;
import com.example.help.service.SecondhandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/secondhand")
public class SecondhandController {

    @Autowired
    SecondhandService secondhandService ;

    @Autowired
    StringRedisTemplate stringRedisTemplate;



    @RequestMapping("/save")
    public ReturnObject secondhandSave(String title ,String content ,String price ,String contact,String contactType,String secondhandUrl) {
        ReturnObject<Secondhand> secondhandReturnObject  = new ReturnObject<Secondhand>();
        secondhandReturnObject.setCode(Code.SUCCESS);
        secondhandReturnObject.setMsg("商品保存成功");
        Secondhand secondhand = new Secondhand();

        //从缓存 获取当前对象stuId
        secondhand.setStuId(stringRedisTemplate.opsForValue().get("CURRENT_USER"));
        secondhand.setContact(contact);
        secondhand.setContactType(contactType);
        secondhand.setPrice(Double.parseDouble(price));
        secondhand.setTitle(title);
        secondhand.setCreateTime(DateUtil.getTimestamp());
        secondhand.setContent(content);
        secondhand.setSecondhandUrl(secondhandUrl);



        secondhandService.secondhandSave(secondhand);

        return secondhandReturnObject;
    }

    @RequestMapping("/list")
    public ReturnObject secondhandList(Secondhand secondhand) {

        ReturnObject<List<SecondHandView>> returnObject = new ReturnObject<List<SecondHandView>>();
            returnObject.setRows(secondhandService.secondhandViewList());
            returnObject.setMsg("hhhh");

        return returnObject;
    }


    @RequestMapping("/want")
    public ReturnObject wantMessage(String message ,String stuIded){
        ReturnObject returnObject = new ReturnObject<>();
        returnObject.setCode(Code.SUCCESS);
        returnObject.setMsg("留言信息保存成功");

        Reviewers reviewers = new Reviewers();
        //从缓存 获取当前对象stuId
        reviewers.setStuId(stringRedisTemplate.opsForValue().get("CURRENT_USER"));
        reviewers.setStuIded(stuIded);
        reviewers.setMessage(message);
        reviewers.setCreateTime(DateUtil.getTimestamp());
        secondhandService.reviewersSave(reviewers);


        return  returnObject ;
 }

    /**
     * 点赞每次 点一次 统计加一 最后靠奇数（点赞） 和 偶数（取消赞）
     * @param stuIded
     * @return
     */
    @RequestMapping("/admire")
    public ReturnObject admire(String stuIded){
        ReturnObject returnObject = new ReturnObject<>();
        returnObject.setMsg("点赞成功");
        Admire adm = new Admire();
        //从缓存 获取当前对象stuId
        adm.setStuId(stringRedisTemplate.opsForValue().get("CURRENT_USER"));
        adm.setStuIded(stuIded);
        secondhandService.addAdmire(adm);
        return  returnObject ;
    }



}
