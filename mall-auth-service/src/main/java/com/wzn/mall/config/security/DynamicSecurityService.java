package com.wzn.mall.config.security;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @program: wzn-mall
 * @description: 动态权限
 * @author: wangzhennan
 * @create: 2020-04-13 17:02
 **/
public interface DynamicSecurityService {

    Map<String, ConfigAttribute> loadDataSource();
}
