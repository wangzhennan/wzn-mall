package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * AdminDto
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("AdminDto")
public class AdminDto implements Serializable {
    private static final long serialVersionUID = 752097768898877419L;
        
    @ApiModelProperty("ID")
    private Long id;
    
        
    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为null")
    @Pattern(regexp = "\\w+$")
    private String username;
    
        
    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为null")
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
    @Pattern(regexp = "\\w+$")
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
    
        
    @ApiModelProperty("修改时间")
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