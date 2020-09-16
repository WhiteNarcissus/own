package com.mjc.own.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_permission")
public class Permission  implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 和t_role 的id 对应
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限 采用url的形式 /login
     */
    @Column(name = "permission")
    private String permission;

    /**
     * 权限描述 
     */
    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}