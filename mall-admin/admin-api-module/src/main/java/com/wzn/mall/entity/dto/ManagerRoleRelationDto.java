package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ManagerRoleRelationDto
 * @author wangzhennan
 * @since 2020-04-14 22:29:24
 */
@Data
@ApiModel("ManagerRoleRelationDto")
public class ManagerRoleRelationDto implements Serializable {
    private static final long serialVersionUID = -51819539159737650L;
        
    @ApiModelProperty("")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long managerId;
    
        
    @ApiModelProperty("")
    private Long roleId;
    
}