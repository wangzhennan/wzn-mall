package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * PermissionMenuRelationDto
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("PermissionMenuRelationDto")
public class PermissionMenuRelationDto implements Serializable {
    private static final long serialVersionUID = -84857943335688515L;
    /**
    * 主键
    */    
    @ApiModelProperty("主键")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long permissionId;
    
        
    @ApiModelProperty("")
    private Long menuId;
    
}