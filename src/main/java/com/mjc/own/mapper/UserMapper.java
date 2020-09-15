package com.mjc.own.mapper;

import com.example.help.domain.Permission;
import com.example.help.domain.Role;
import com.example.help.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gcb on 2019/2/27.
 */
@Repository
public interface UserMapper  extends TkMapper<User> {

    List<User>  queryUserById ();

    Role queryRoleById(User user);

}