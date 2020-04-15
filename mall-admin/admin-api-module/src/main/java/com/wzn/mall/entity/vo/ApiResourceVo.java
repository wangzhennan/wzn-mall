package com.wzn.mall.entity.vo;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ApiResourceVo
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("ApiResourceVo" )
public class ApiResourceVo implements Serializable {
    private static final long serialVersionUID = 836201918011856050L;
        
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
    
    /**
    * 父ID
    */    
    @ApiModelProperty("父ID")
    private Long pid;
    
    /**
    * 级别
    */    
    @ApiModelProperty("级别")
    private String level;
    
}