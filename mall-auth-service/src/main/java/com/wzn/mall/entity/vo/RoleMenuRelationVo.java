package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleMenuRelationVo
 * @author wzn
 * @since 2020-04-13 19:16:41
 */
@Data
@ApiModel("RoleMenuRelationVo" )
public class RoleMenuRelationVo implements Serializable {
    private static final long serialVersionUID = 240426455093096677L;
        
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