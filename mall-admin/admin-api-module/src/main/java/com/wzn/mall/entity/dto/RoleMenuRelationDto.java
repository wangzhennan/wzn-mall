package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleMenuRelationDto
 * @author wangzhennan
 * @since 2020-04-14 22:29:24
 */
@Data
@ApiModel("RoleMenuRelationDto")
public class RoleMenuRelationDto implements Serializable {
    private static final long serialVersionUID = 590774469791966083L;
        
    @ApiModelProperty("")
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