package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerPermissionRelationDto
 * @author wzn
 * @since 2020-04-13 19:16:39
 */
@Data
@ApiModel("ManagerPermissionRelationDto")
public class ManagerPermissionRelationDto implements Serializable {
    private static final long serialVersionUID = 213395108462579240L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long managerId;
    
        
    @ApiModelProperty("$column.comment")
    private Long permissionId;
    
        
    @ApiModelProperty("$column.comment")
    private Integer type;
    
}