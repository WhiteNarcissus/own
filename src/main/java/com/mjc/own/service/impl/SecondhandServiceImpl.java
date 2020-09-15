package com.example.help.service.impl;

import com.example.help.common.DateUtil;
import com.example.help.domain.*;
import com.example.help.mapper.AdmireMapper;
import com.example.help.mapper.ReviewersMapper;
import com.example.help.mapper.SecondhandMapper;
import com.example.help.service.SecondhandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SecondhandServiceImpl implements SecondhandService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SecondhandMapper secondhandMapper ;
    @Autowired
    ReviewersMapper reviewersMapper ;
    @Autowired
    AdmireMapper admireMapper ;



    @Override
    public void secondhandSave(Secondhand secondhand) {
        secondhandMapper.insert(secondhand);
    }

    @Override
    public List<Secondhand> secondhandList() {
        Example example = new Example(Secondhand.class);
        example.createCriteria().andNotEqualTo("id",0);
        example.setOrderByClause("create_time DESC");

        return secondhandMapper.selectByExample(example);
    }

    @Override
    public void reviewersSave(Reviewers reviewers) {
        reviewersMapper.insert(reviewers);
    }

    @Override
    public void addAdmire(Admire admire) {

       if(admireMapper.select(admire).isEmpty()){
           //第一次查不出来记录 插入一条空记录
           admire.setAdmire(1);
           admire.setCreateTime(DateUtil.getTimestamp());
           admireMapper.insert(admire);
       }else {
           //每次前端点击一下 后台点赞数加一
           Admire adm = admireMapper.select(admire).get(0);
           adm.setAdmire(adm.getAdmire()+1);
           adm.setCreateTime(DateUtil.getTimestamp());
           admireMapper.updateAdmire(adm);
       }


    }

    @Override
    public List<SecondHandView> secondhandViewList() {
        List<SecondHandView> secondHandViewList = new ArrayList<>();


        Example example = new Example(Secondhand.class);
        example.createCriteria().andNotEqualTo("id",0);
        example.setOrderByClause("create_time DESC");
        List<Secondhand> secondhands = secondhandMapper.selectByExample(example);

        List<Admire> admires = admireMapper.selectAll();
        List<Reviewers> reviewers = reviewersMapper.selectAll();

        if (!secondhands.isEmpty()) {
            for (Secondhand secondhand : secondhands) {

                SecondHandView secondHandView = new SecondHandView();
                List listReview = new ArrayList();
                List<Admire> listAdmire = new ArrayList();

                secondHandView.setStuId(secondhand.getStuId());
                secondHandView.setContent(secondhand.getContent());
                secondHandView.setPrice(secondhand.getPrice());
                secondHandView.setCreateTime(secondhand.getCreateTime());
                secondHandView.setContact(secondhand.getContact());
                secondHandView.setContactType(secondhand.getContactType());

                //设置时间差
                String timeCut = "" ;
                Date now =new  Date();

                long between=(now.getTime()-secondhand.getCreateTime().getTime())/1000;//除以1000是为了转换成秒

                long day1=between/(24*3600);
                long hour1=between%(24*3600)/3600;
                long minute1=between%3600/60;
                long second1=between%60/60;
                if(day1 != 0){
                    timeCut= ""+day1+"天"+hour1+"小时"+minute1+"分" ;
                }
                else if (hour1 !=0 ){
                    timeCut=""+hour1+"小时"+minute1+"分" ;
                }
                else if (minute1 !=0 ){
                    timeCut=""+minute1+"分" ;
                }else {
                    timeCut =""+second1+"秒";
                }

                secondHandView.setPushTimeCut(timeCut);


                //将多张图片 用一个集合来收集
                List<String> img = new ArrayList<>();
                if (null != secondhand.getSecondhandUrl() && !"".equals(secondhand.getSecondhandUrl())) {
                    String[] spil = secondhand.getSecondhandUrl().trim().split(",");

                    for (int i = 0; i < spil.length; i++) {
                        String str = spil[i];
                        img.add(str);
                    }
                }
                secondHandView.setPushImageUrl(img);

                //评论列表
                for (Reviewers review : reviewers) {
                    if (review.getStuIded().equals(secondhand.getStuId())) {
                        listReview.add(review);
                    }
                }
                //点赞列表
                for (Admire admir : admires) {
                    if (admir.getStuIded().equals(secondhand.getStuId())) {
                        listAdmire.add(admir);
                    }
                }


                if (!listReview.isEmpty()) {
                    secondHandView.setReviewers(listReview);
                }
                //如果点赞数是奇数，则为点赞 否则 为取消点赞
                if (!listAdmire.isEmpty()) {
                    for(int x= 0 ;x<listAdmire.size();x++){
                        String admireStr = "";
                        Integer  count= listAdmire.get(x).getAdmire();
                         if((count&1) == 1) {   //是奇数
                             admireStr = listAdmire.get(x).getStuId() + ","+admireStr;
                         }
                        admireStr = admireStr+"...";
                        secondHandView.setAdmires(admireStr);
                    }

                }


                secondHandViewList.add(secondHandView);
            }


        }


        return secondHandViewList;
    }
}
