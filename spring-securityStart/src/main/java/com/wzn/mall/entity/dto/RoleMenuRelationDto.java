package com.wzn.mall.entity.vo.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleMenuRelationDto
 * @author wzn
 * @since 2020-04-14 22:03:25
 */
@Data
@ApiModel("RoleMenuRelationDto")
public class RoleMenuRelationDto implements Serializable {
    private static final long serialVersionUID = -58981449363815122L;
        
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