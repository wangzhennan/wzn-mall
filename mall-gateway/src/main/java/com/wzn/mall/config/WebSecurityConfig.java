package com.wzn.mall.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-19 13:28
 **/
@EnableWebFluxSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 很重要
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}
