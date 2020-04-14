package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * RoleResourceRelationDto
 * @author wangzhennan
 * @since 2020-04-14 22:29:25
 */
@Data
@ApiModel("RoleResourceRelationDto")
public class RoleResourceRelationDto implements Serializable {
    private static final long serialVersionUID = 299981963515195023L;
        
    @ApiModelProperty("")
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