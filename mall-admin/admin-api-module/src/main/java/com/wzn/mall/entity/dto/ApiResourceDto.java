package com.wzn.mall.entity.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ApiResourceDto
 * @author wangzhennan
 * @since 2020-04-14 22:29:24
 */
@Data
@ApiModel("ApiResourceDto")
public class ApiResourceDto implements Serializable {
    private static final long serialVersionUID = 130331114078685387L;
        
    @ApiModelProperty("")
    private Long id;
    
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date ctime;
    
    /**
    * 资源名称
    */    
    @ApiModelProperty("资源名称")
    private String name;
    
    /**
    * 资源URL
    */    
    @ApiModelProperty("资源URL")
    private String url;
    
    /**
    * 描述
    */    
    @ApiModelProperty("描述")
    private String description;
    
    /**
    * 资源分类ID
    */    
    @ApiModelProperty("资源分类ID")
    private Long categoryId;
    
        
    @ApiModelProperty("")
    private String tag;
    
}