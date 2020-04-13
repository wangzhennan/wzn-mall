package com.wzn.mall.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsUtils;


/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-10 13:48
 **/

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired(required = false)
    private DynamicSecurityService dynamicSecurityService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        // 支持跨域
        registry.requestMatchers(CorsUtils::isCorsRequest).permitAll();
        // 禁止session
        registry.and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().headers().cacheControl();
        // 添加不拦截url
        if (CollectionUtils.isEmpty(securityPassUrls().getUrls())) {
            securityPassUrls().getUrls().stream().forEach(p -> {
                registry.antMatchers(p).permitAll();
            });
        }
        //其他情况全部拦截
        registry.and().authorizeRequests().anyRequest().hasAnyAuthority();
        //添加JWT拦截器
        registry.and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //异常处理
        registry.and().exceptionHandling().authenticationEntryPoint(resultAuthenticationEntryPoint()).accessDeniedHandler(resultAccessDeniedHandler());
        // 动态数据
        if (null != dynamicSecurityService) {
            registry.and().addFilterBefore(dynamicSecurityFilter(), FilterSecurityInterceptor.class);
        }
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    /**
     * 获取不拦截url
     *
     * @return
     */
    @Bean
    public SecurityPassUrlsConfig securityPassUrls() {
        return new SecurityPassUrlsConfig();
    }

    /**
     * Jwt
     *
     * @return
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 自定义 异常输出
     *
     * @return
     */
    @Bean
    public ResultAuthenticationEntryPoint resultAuthenticationEntryPoint() {
        return new ResultAuthenticationEntryPoint();
    }

    @Bean
    public ResultAccessDeniedHandler resultAccessDeniedHandler() {
        return new ResultAccessDeniedHandler();
    }


    @Bean
    public DynamicSecurityFilter dynamicSecurityFilter() {
        return new DynamicSecurityFilter();
    }

    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
        return new DynamicSecurityMetadataSource();
    }

    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
        return new DynamicAccessDecisionManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
