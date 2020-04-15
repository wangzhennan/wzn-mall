package com.wzn.mall.entity.vo.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerLogDto
 * @author wzn
 * @since 2020-04-14 21:55:25
 */
@Data
@ApiModel("ManagerLogDto")
public class ManagerLogDto implements Serializable {
    private static final long serialVersionUID = -74156200800488019L;
        
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