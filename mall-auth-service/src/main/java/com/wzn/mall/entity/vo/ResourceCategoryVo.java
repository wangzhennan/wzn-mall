package com.wzn.mall.entity.vo;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ResourceCategoryVo
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("ResourceCategoryVo" )
public class ResourceCategoryVo implements Serializable {
    private static final long serialVersionUID = -71158284642922900L;
        
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