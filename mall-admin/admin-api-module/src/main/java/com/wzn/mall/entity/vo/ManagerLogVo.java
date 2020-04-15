package com.wzn.mall.entity.vo;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerLogVo
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("ManagerLogVo" )
public class ManagerLogVo implements Serializable {
    private static final long serialVersionUID = 573056375779268260L;
        
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