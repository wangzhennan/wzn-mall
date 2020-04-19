package com.wzn.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-18 17:24
 **/
@Configuration
public class TokenConfig {
    private String SINGKEY = "wzn";

    @Bean
    public TokenStore tokenStore() {
        //缓存
        //return new InMemoryTokenStore();
        //集成jWT
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SINGKEY);
        return converter;
    }

    public static void main(String[] args) {
        //

        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
