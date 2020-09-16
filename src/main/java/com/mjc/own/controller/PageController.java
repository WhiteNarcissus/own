package com.mjc.own.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 *页面跳转
 */
@Controller
public class PageController {
    @RequestMapping("/page")
    public String page3(Model model){
        model.addAttribute("userName","张三");
        return "hello";
    }
 
    @RequestMapping("/home/main")
    public String page(){
        return "home/main";
    }
 
    @RequestMapping("/knowledge")
    public String knowledge(){
        return "knowledge";
    }


    @RequestMapping("/knowledgeList")
    public String knowledgeList(){
        return "knowledgeList";
    }


}//访问只能是tem文件夹
