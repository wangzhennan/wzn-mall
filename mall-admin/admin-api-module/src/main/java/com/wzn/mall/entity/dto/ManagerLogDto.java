package com.wzn.mall.entity.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerLogDto
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("ManagerLogDto")
public class ManagerLogDto implements Serializable {
    private static final long serialVersionUID = 952020611161168676L;
        
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