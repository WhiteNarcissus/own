package com.example.help.service.impl;

import com.example.help.domain.User;
import com.example.help.mapper.UserMapper;
import com.example.help.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

   @Autowired
   UserMapper userMapper ;
    @Override
    public User selectOne(User u) {

        return userMapper.selectOne(u);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
