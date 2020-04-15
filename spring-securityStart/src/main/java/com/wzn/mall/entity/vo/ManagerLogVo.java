package com.wzn.mall.entity.vo;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerLogVo
 * @author wzn
 * @since 2020-04-14 21:55:25
 */
@Data
@ApiModel("ManagerLogVo" )
public class ManagerLogVo implements Serializable {
    private static final long serialVersionUID = 593578189633500954L;
        
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