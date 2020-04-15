package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * RolePermissionRelationDto
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
@Data
@ApiModel("RolePermissionRelationDto")
public class RolePermissionRelationDto implements Serializable {
    private static final long serialVersionUID = -80702145819622835L;
    /**
    * 主键
    */    
    @ApiModelProperty("主键")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long roleId;
    
        
    @ApiModelProperty("")
    private Long permissionId;
    
}