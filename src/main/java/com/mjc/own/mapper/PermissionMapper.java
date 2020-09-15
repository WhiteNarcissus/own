package com.mjc.own.mapper;


import com.example.help.domain.Permission;
import com.example.help.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PermissionMapper extends TkMapper<Permission> {

    List<Permission> queryRolePermissionByUser(User user);

}