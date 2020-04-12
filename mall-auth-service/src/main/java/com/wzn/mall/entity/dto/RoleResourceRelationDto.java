package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleResourceRelationDto
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("RoleResourceRelationDto")
public class RoleResourceRelationDto implements Serializable {
    private static final long serialVersionUID = -22752390858529887L;
        
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