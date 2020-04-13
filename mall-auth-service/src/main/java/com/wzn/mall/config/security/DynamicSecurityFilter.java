package com.wzn.mall.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: wzn-mall
 * @description: 动态过滤器
 * @author: wangzhennan
 * @create: 2020-04-13 17:50
 **/
public class DynamicSecurityFilter extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @Autowired
    private SecurityPassUrlsConfig securityPassUrlsConfig;

    @Autowired
    public void setDynamicAccessDecisionManager(DynamicAccessDecisionManager dynamicAccessDecisionManager) {
        super.setAccessDecisionManager(dynamicAccessDecisionManager);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        FilterInvocation filterInvocation = new FilterInvocation(servletRequest, servletResponse, filterChain);
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
            return;
        }
        //白名单
        PathMatcher pathMatcher = new AntPathMatcher();
        securityPassUrlsConfig.getUrls().stream().forEach(url -> {
            if (pathMatcher.match(url, request.getRequestURI())) {
                try {
                    filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
                } catch (Exception e) {
                    throw new RuntimeException("系统异常");
                }
            }
        });

        try {
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
        } finally {
            InterceptorStatusToken interceptorStatusToken = super.beforeInvocation(filterInvocation);
            super.afterInvocation(interceptorStatusToken, null);
        }

    }

    @Override
    public void destroy() {

    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return dynamicSecurityMetadataSource;
    }


    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }
}
