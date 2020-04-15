package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: wzn-mall
 * @description: 用户查询参数类
 * @author: wangzhennan
 * @create: 2020-04-15 18:11
 **/
@Data
@ApiModel("用户查询")
public class AdminQueryParam extends PageInit {

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("角色Id")
    private Long roleId;
}
