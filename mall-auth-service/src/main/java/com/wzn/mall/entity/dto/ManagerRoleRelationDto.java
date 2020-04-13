package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerRoleRelationDto
 * @author wzn
 * @since 2020-04-13 19:16:39
 */
@Data
@ApiModel("ManagerRoleRelationDto")
public class ManagerRoleRelationDto implements Serializable {
    private static final long serialVersionUID = 744768629624899355L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long managerId;
    
        
    @ApiModelProperty("$column.comment")
    private Long roleId;
    
}