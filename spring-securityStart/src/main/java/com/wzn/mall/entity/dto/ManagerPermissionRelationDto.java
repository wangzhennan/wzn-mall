package com.wzn.mall.entity.vo.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerPermissionRelationDto
 * @author wzn
 * @since 2020-04-14 21:53:19
 */
@Data
@ApiModel("ManagerPermissionRelationDto")
public class ManagerPermissionRelationDto implements Serializable {
    private static final long serialVersionUID = 986427311319533189L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long managerId;
    
        
    @ApiModelProperty("$column.comment")
    private Long permissionId;
    
        
    @ApiModelProperty("$column.comment")
    private Integer type;
    
}