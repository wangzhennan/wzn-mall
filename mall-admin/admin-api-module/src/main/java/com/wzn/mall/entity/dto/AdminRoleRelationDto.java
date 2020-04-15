package com.wzn.mall.entity.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * AdminRoleRelationDto
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("AdminRoleRelationDto")
public class AdminRoleRelationDto implements Serializable {
    private static final long serialVersionUID = 397709798312804933L;
    /**
    * 主键
    */    
    @ApiModelProperty("主键")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long adminId;
    
        
    @ApiModelProperty("")
    private Long roleId;
    
}