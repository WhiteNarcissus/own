package com.mjc.own.controller;


import com.mjc.own.domain.User;
import com.mjc.own.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gcb on 2019/2/27.
 */
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable int id){
      User u = new User();
      u.setUserId(id+0l);

        return u;
    }


    @RequestMapping("getUserList")
    public List<User> getUserList(){


        return null;
    }

}
