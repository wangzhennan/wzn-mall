package com.wzn.mall.entity.dto;

import lombok.Data;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-15 18:34
 **/
@Data
public class RoleQueryParam extends PageInit {
    private String roleName;
}
