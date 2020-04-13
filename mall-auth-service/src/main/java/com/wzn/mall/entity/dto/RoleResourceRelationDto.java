package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleResourceRelationDto
 * @author wzn
 * @since 2020-04-13 19:16:41
 */
@Data
@ApiModel("RoleResourceRelationDto")
public class RoleResourceRelationDto implements Serializable {
    private static final long serialVersionUID = -44002352000547095L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
    /**
    * 角色ID
    */    
    @ApiModelProperty("角色ID")
    private Long roleId;
    
    /**
    * 资源ID
    */    
    @ApiModelProperty("资源ID")
    private Long resourceId;
    
}