package com.wzn.mall.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-15 20:07
 **/
@ApiModel("资源查询Bean")
@Data
public class ApisResourceQueryParam extends PageInit {
    @ApiModelProperty("资源名称精准匹配")
    private String name;
    @ApiModelProperty("资源类型 ->父ID")
    private Long type;
}
