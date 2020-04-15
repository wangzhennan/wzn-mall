package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * PermissionApiResourceRelationDto
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("PermissionApiResourceRelationDto")
public class PermissionApiResourceRelationDto implements Serializable {
    private static final long serialVersionUID = 341327712763080613L;
        
    @ApiModelProperty("")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long permissionId;
    
        
    @ApiModelProperty("")
    private Long apiResourceId;
    
}