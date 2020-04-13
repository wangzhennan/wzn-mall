package com.wzn.mall.entity.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerLogDto
 * @author wzn
 * @since 2020-04-13 19:16:38
 */
@Data
@ApiModel("ManagerLogDto")
public class ManagerLogDto implements Serializable {
    private static final long serialVersionUID = -67829023943941507L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long adminId;
    
        
    @ApiModelProperty("$column.comment")
    private Date ctime;
    
        
    @ApiModelProperty("$column.comment")
    private String ip;
    
        
    @ApiModelProperty("$column.comment")
    private String address;
    
    /**
    * 浏览器登录类型
    */    
    @ApiModelProperty("浏览器登录类型")
    private String userAgent;
    
}