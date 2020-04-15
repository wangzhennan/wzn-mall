package com.wzn.mall.entity.vo;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * AdminLogVo
 * @author wangzhennan
 * @since 2020-04-15 15:27:31
 */
@Data
@ApiModel("AdminLogVo" )
public class AdminLogVo implements Serializable {
    private static final long serialVersionUID = -67396802124800894L;
        
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