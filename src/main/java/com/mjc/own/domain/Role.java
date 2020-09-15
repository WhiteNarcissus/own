package com.example.help.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_role")
public class Role  implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 角色名 admin 超管（增删改查）；guest 访客 （查看）；organizer （新增修改查看）
     */
    @Column(name = "role")
    private String role;

    @Column(name = "role_description")
    private String roleDescription;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色名 admin 超管（增删改查）；guest 访客 （查看）；organizer （新增修改查看）
     *
     * @return role - 角色名 admin 超管（增删改查）；guest 访客 （查看）；organizer （新增修改查看）
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置角色名 admin 超管（增删改查）；guest 访客 （查看）；organizer （新增修改查看）
     *
     * @param role 角色名 admin 超管（增删改查）；guest 访客 （查看）；organizer （新增修改查看）
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return role_description
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * @param roleDescription
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}