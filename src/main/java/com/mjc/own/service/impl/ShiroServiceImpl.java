package com.example.help.service.impl;



import com.example.help.common.Code;
import com.example.help.common.MyException;
import com.example.help.domain.AuthInfo;
import com.example.help.domain.Permission;
import com.example.help.domain.Role;
import com.example.help.domain.User;
import com.example.help.mapper.PermissionMapper;
import com.example.help.mapper.UserMapper;
import com.example.help.service.ShiroService;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gcb on 2019/1/3.
 */
@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper ;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;




    @Override
    public User selectOne(User u) {
        return userMapper.selectOne(u);
    }

    @Override
    public List<Permission> getPermissionsByUser(User user) {

        List<Permission> permissions =  permissionMapper.queryRolePermissionByUser(user);

        return permissions;
    }

    @Override
    public Role curRole(User user) {
        return userMapper.queryRoleById(user);
    }



    @Override
    public void  putAuth2Redis(Subject subject, User user) {
       AuthInfo authInfo = new AuthInfo();

         authInfo.setStuId(user.getStuId());
        if(subject.hasRole("admin")){
           authInfo.setRole("admin");
        }
        if(subject.hasRole("guest")){
            authInfo.setRole("guest");
        }
        if(subject.hasRole("student")){
            authInfo.setRole("student");
        }
        if (subject.isPermitted("/edit"))
        {
            authInfo.setPermission("/edit");
        }

            try {
                stringRedisTemplate.opsForHash().put("AUTH",String.valueOf(user.getStuId()),authInfo.getRole()+":"+authInfo.getPermission());
            }catch (Exception e){
              e.printStackTrace();
              throw new  MyException("将数据放入缓存失败",Code.FAIL);

            }



    }
}

