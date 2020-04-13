package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleMenuRelationDto
 * @author wzn
 * @since 2020-04-13 19:16:41
 */
@Data
@ApiModel("RoleMenuRelationDto")
public class RoleMenuRelationDto implements Serializable {
    private static final long serialVersionUID = 654882717683494161L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
    /**
    * 角色ID
    */    
    @ApiModelProperty("角色ID")
    private Long roleId;
    
    /**
    * 菜单ID
    */    
    @ApiModelProperty("菜单ID")
    private Long menuId;
    
}