package com.wzn.mall.entity;

import javax.persistence.*;

@Table(name = "role_resource_relation")
public class RoleResourceRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 资源ID
     */
    @Column(name = "resource_id")
    private Long resourceId;

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
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取资源ID
     *
     * @return resource_id - 资源ID
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源ID
     *
     * @param resourceId 资源ID
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}