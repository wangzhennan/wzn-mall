package com.wzn.mall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-19 10:36
 **/
@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        //资源Id
        resources.resourceId("zuul")
                //远程调用
                //.tokenServices(tokenServices())
                //tokenStort验证
                .tokenStore(tokenStore)
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**")
                //作用域
                .access("#oauth2.hasScope('all')")
                //跨域
                .and().csrf().disable()
                //禁止session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /*//@Bean
    public RemoteTokenServices tokenServices() {
        //制定远程调用服务
        RemoteTokenServices services = new RemoteTokenServices();
        //服务地址
        services.setCheckTokenEndpointUrl("http://127.0.0.1:8072/auth-service/oauth/check_token");
        //权限Id
        services.setClientId("wzn");
        services.setClientSecret("123");
        return services;
    }*/
}
