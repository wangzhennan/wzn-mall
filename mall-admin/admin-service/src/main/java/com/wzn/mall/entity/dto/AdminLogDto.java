package com.wzn.mall.entity.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * AdminLogDto
 * @author wangzhennan
 * @since 2020-04-15 15:27:31
 */
@Data
@ApiModel("AdminLogDto")
public class AdminLogDto implements Serializable {
    private static final long serialVersionUID = 733272231328835567L;
        
    @ApiModelProperty("")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long adminId;
    
        
    @ApiModelProperty("")
    private Date ctime;
    
        
    @ApiModelProperty("")
    private String ip;
    
        
    @ApiModelProperty("")
    private String address;
    
    /**
    * 浏览器登录类型
    */    
    @ApiModelProperty("浏览器登录类型")
    private String userAgent;
    
}