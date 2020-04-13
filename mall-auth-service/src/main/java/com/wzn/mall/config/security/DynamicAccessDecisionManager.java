package com.wzn.mall.config.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @program: wzn-mall
 * @description: 权限管理
 * @author: wangzhennan
 * @create: 2020-04-13 18:26
 **/
public class DynamicAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (CollectionUtils.isEmpty(configAttributes)) {
            return;
        }
        configAttributes.stream().forEach(p -> {
            String needAuth = p.getAttribute();
            authentication.getAuthorities().stream().forEach(pp -> {
                if (needAuth.trim().equals(((GrantedAuthority) pp).getAuthority())) {
                    return;
                }
            });
        });
        throw new AccessDeniedException("权限不足，无法访问");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
