package com.wzn.mall.entity.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerDto
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("ManagerDto")
public class ManagerDto implements Serializable {
    private static final long serialVersionUID = -49051440146927086L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private String username;
    
        
    @ApiModelProperty("$column.comment")
    private String password;
    
    /**
    * 头像
    */    
    @ApiModelProperty("头像")
    private String icon;
    
    /**
    * 邮箱
    */    
    @ApiModelProperty("邮箱")
    private String email;
    
    /**
    * 昵称
    */    
    @ApiModelProperty("昵称")
    private String nickName;
    
    /**
    * 备注信息
    */    
    @ApiModelProperty("备注信息")
    private String note;
    
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date ctime;
    
        
    @ApiModelProperty("$column.comment")
    private Date utime;
    
    /**
    * 最后登录时间
    */    
    @ApiModelProperty("最后登录时间")
    private Date lastLoginTime;
    
    /**
    * 帐号状态：0->禁用；1->启用
    */    
    @ApiModelProperty("帐号状态：0->禁用；1->启用")
    private Boolean status;
    
}