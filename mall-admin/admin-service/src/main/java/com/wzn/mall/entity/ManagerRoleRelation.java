package com.wzn.mall.entity;

import javax.persistence.*;

@Table(name = "manager_role_relation")
public class ManagerRoleRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "role_id")
    private Long roleId;

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
     * @return manager_id
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param managerId
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}