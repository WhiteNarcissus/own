package com.example.help.service;


import com.example.help.domain.Admire;
import com.example.help.domain.Reviewers;
import com.example.help.domain.SecondHandView;
import com.example.help.domain.Secondhand;

import java.util.List;

public interface SecondhandService {

    /**
     * 保存一条二手商品信息进数据库
     * @param secondhand
     */
    void  secondhandSave(Secondhand secondhand) ;


    List<Secondhand> secondhandList();

    void reviewersSave(Reviewers reviewers);

    void addAdmire(Admire admire);

    /**
     * 二手信息展示VO（类似朋友圈展示）
     * @return List<SecondHandView>
     */
    List<SecondHandView> secondhandViewList();



}
