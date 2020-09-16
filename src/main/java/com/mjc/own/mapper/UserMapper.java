package com.mjc.own.mapper;


import com.mjc.own.domain.Role;
import com.mjc.own.domain.User;
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