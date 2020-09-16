package com.mjc.own.service;




import com.mjc.own.domain.Permission;
import com.mjc.own.domain.Role;
import com.mjc.own.domain.User;
import org.apache.shiro.subject.Subject;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by gcb on 2019/1/3.
 */
public interface ShiroService  {

    User selectOne(User u);
    List<Permission> getPermissionsByUser(User user);
    Role curRole(User user);

   void putAuth2Redis(Subject subject ,User user);

}
