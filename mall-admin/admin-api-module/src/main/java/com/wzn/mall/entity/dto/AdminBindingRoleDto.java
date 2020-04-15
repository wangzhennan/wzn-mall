package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program: wzn-mall
 * @description: 绑定角色
 * @author: wangzhennan
 * @create: 2020-04-14 23:42
 **/
@ApiModel("绑定类")
@Data
public class AdminBindingRoleDto {
    @ApiModelProperty("管理员Id")
    @NotNull(message = "管理员Id必填")
    private Long id;

    @ApiModelProperty("角色Id")
    @NotNull(message = "角色id必填")
    private List<Long> roleIds;
}
