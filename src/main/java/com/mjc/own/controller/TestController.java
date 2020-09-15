package com.example.help.controller;

import com.example.help.domain.Role;
import com.example.help.domain.Test;
import com.example.help.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gcb on 2019/2/26.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testBoot")
public class TestController {

    @Autowired
    private TestMapper testMapper ;

    @RequestMapping("getRole")
    public Role getRole(){
         Role role = new Role();
         role.setId(1l);
         role.setRole("zs");
         role.setRoleDescription("for test");
         return role;

    }



    @RequestMapping("test")
    public List<Test> test(){

       List<Test> t = testMapper.selectAll();

        return t;

    }






}
