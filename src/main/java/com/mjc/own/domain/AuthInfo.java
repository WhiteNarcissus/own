package com.mjc.own.domain;

import java.io.Serializable;

/**
 * Created by gcb on 2019/3/29.
 * 权限信息类
 */
public class AuthInfo implements Serializable{
    //学号 用户名
    private String stuId;
    //权限
    private String permission;
    // 角色
    private String role;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
