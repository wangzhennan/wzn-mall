package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program: wzn-mall
 * @description: 添加菜单资源类
 * @author: wangzhennan
 * @create: 2020-04-15 11:32
 **/
@ApiModel("添加资源菜单")
@Data
public class BindingObjectDto {

    @ApiModelProperty("角色id")
    @NotNull(message = "角色ID必填")
    private Long id;

    @ApiModelProperty("ids集合 菜单绑定是菜单ids 资源绑定是资源ids")
    @NotNull(message = "ids必填")
    private List<Long> objectList;
}
