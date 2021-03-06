package com.wzn.mall.entity.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * MenuDto
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("MenuDto")
public class MenuDto implements Serializable {
    private static final long serialVersionUID = 594188329556505919L;
        
    @ApiModelProperty("")
    private Long id;
    
    /**
    * 父级ID
    */    
    @ApiModelProperty("父级ID")
    private Long pid;
    
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date ctime;
    
    /**
    * 菜单名称
    */    
    @ApiModelProperty("菜单名称")
    private String title;
    
    /**
    * 菜单级别
    */    
    @ApiModelProperty("菜单级别")
    private Integer level;
    
    /**
    * 菜单排序
    */    
    @ApiModelProperty("菜单排序")
    private Integer sort;
    
    /**
    * 前端名称
    */    
    @ApiModelProperty("前端名称")
    private String name;
    
    /**
    * 前端图标
    */    
    @ApiModelProperty("前端图标")
    private String icon;
    
    /**
    * 前端隐藏 1 隐藏 0不隐藏
    */    
    @ApiModelProperty("前端隐藏 1 隐藏 0不隐藏")
    private Boolean isHidden;
    
}