package com.wzn.mall.entity.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleDto
 * @author wzn
 * @since 2020-04-13 19:16:41
 */
@Data
@ApiModel("RoleDto")
public class RoleDto implements Serializable {
    private static final long serialVersionUID = -75960044652921775L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
    /**
    * 名称
    */    
    @ApiModelProperty("名称")
    private String name;
    
    /**
    * 描述
    */    
    @ApiModelProperty("描述")
    private String description;
    
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date ctime;
    
    /**
    * 启用状态：0->禁用；1->启用
    */    
    @ApiModelProperty("启用状态：0->禁用；1->启用")
    private Boolean status;
    
        
    @ApiModelProperty("$column.comment")
    private Integer sort;
    
}