package com.wzn.mall.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: wzn-mall
 * @description: 安全认证需要过滤的url
 * @author: wangzhennan
 * @create: 2020-04-13 14:18
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "security.filter.urls")
public class SecurityPassUrlsConfig {

    private List<String> urls = new ArrayList<>();
}
