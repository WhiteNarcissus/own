package com.mjc.own.mapper;



import com.mjc.own.domain.Permission;
import com.mjc.own.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PermissionMapper extends TkMapper<Permission> {

    List<Permission> queryRolePermissionByUser(User user);

}