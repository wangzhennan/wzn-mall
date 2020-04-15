package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * RoleDto
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
@Data
@ApiModel("RoleDto")
public class RoleDto implements Serializable {
    private static final long serialVersionUID = 532508706571040723L;
        
    @ApiModelProperty("")
    private Long id;
    
    /**
    * 名称
    */    
    @ApiModelProperty("名称")
    @NotNull(message = "名称不能null")
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


    @ApiModelProperty("排序")
    private Integer sort;
    
}