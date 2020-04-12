package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleMenuRelationVo
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("RoleMenuRelationVo" )
public class RoleMenuRelationVo implements Serializable {
    private static final long serialVersionUID = 953524607039081298L;
        
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