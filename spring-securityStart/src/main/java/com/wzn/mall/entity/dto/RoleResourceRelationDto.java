package com.wzn.mall.entity.vo.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleResourceRelationDto
 * @author wzn
 * @since 2020-04-14 22:03:25
 */
@Data
@ApiModel("RoleResourceRelationDto")
public class RoleResourceRelationDto implements Serializable {
    private static final long serialVersionUID = -51173699027286404L;
        
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