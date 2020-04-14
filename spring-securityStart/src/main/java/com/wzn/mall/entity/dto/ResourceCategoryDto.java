package com.wzn.mall.entity.vo.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ResourceCategoryDto
 * @author wzn
 * @since 2020-04-14 22:02:11
 */
@Data
@ApiModel("ResourceCategoryDto")
public class ResourceCategoryDto implements Serializable {
    private static final long serialVersionUID = -80802273541339204L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date ctime;
    
    /**
    * 分类名称
    */    
    @ApiModelProperty("分类名称")
    private String name;
    
    /**
    * 排序
    */    
    @ApiModelProperty("排序")
    private Integer sort;
    
}