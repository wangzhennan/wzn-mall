package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerPermissionRelationDto
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("ManagerPermissionRelationDto")
public class ManagerPermissionRelationDto implements Serializable {
    private static final long serialVersionUID = -54635793711093203L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long managerId;
    
        
    @ApiModelProperty("$column.comment")
    private Long permissionId;
    
        
    @ApiModelProperty("$column.comment")
    private Integer type;
    
}