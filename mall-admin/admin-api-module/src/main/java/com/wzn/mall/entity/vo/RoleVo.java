package com.wzn.mall.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * RoleVo
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
@Data
@ApiModel("RoleVo" )
public class RoleVo implements Serializable {
    private static final long serialVersionUID = 620422097148667097L;
        
    @ApiModelProperty("")
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
    
        
    @ApiModelProperty("")
    private Integer sort;
    
}