package com.wzn.mall.entity;

import javax.persistence.*;

@Table(name = "permission_api_resource_relation")
public class PermissionApiResourceRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission_id")
    private Long permissionId;

    @Column(name = "api_resource_id")
    private Long apiResourceId;

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
     * @return permission_id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return api_resource_id
     */
    public Long getApiResourceId() {
        return apiResourceId;
    }

    /**
     * @param apiResourceId
     */
    public void setApiResourceId(Long apiResourceId) {
        this.apiResourceId = apiResourceId;
    }
}