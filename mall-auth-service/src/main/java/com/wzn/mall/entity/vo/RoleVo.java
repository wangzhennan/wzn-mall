package com.wzn.mall.entity.vo;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleVo
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("RoleVo" )
public class RoleVo implements Serializable {
    private static final long serialVersionUID = -29704510814328316L;
        
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