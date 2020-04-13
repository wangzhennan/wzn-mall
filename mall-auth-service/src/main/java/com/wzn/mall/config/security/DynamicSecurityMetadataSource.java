package com.wzn.mall.config.security;

import com.sun.xml.internal.ws.util.UtilException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @program: wzn-mall
 * @description: 动态获取权限
 * @author: wangzhennan
 * @create: 2020-04-13 17:54
 **/
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired(required = false)
    private DynamicSecurityService dynamicSecurityService;

    private static Map<String, ConfigAttribute> configAttributeMap = null;

    @PostConstruct
    public void loadDataSource() {
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (CollectionUtils.isEmpty(configAttributeMap)) {
            loadDataSource();
        }
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        FilterInvocation invocation = (FilterInvocation) object;
        String requestUrl = invocation.getRequestUrl();
        URI uri;
        try {
            uri = new URI(requestUrl);
        } catch (URISyntaxException e) {
            throw new UtilException(e);
        }
        String path = uri.getPath();
        PathMatcher pathMatcher = new AntPathMatcher();
        configAttributeMap.forEach((p, v) -> {
            if (pathMatcher.match(p, path)) {
                configAttributes.add(v);
            }
        });
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    public void clearDataSource() {
        configAttributeMap.clear();
        configAttributeMap = null;
    }
}
