package com.mjc.own.service;


import com.mjc.own.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gcb on 2019/2/27.
 */
public interface UserService {

   User selectOne(User u);

   List<User> selectAll();
}
