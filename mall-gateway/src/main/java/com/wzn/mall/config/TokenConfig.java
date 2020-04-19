package com.wzn.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @program: wzn-mall
 * @description:TokenStore 类型制定JWT
 * @author: wangzhennan
 * @create: 2020-04-19 13:20
 **/
@Configuration
public class TokenConfig {

    String SINGKEY = "wzn";

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(SINGKEY);
        return jwtAccessTokenConverter;
    }
}
