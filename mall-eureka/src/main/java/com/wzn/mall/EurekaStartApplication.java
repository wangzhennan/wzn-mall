package com.wzn.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-06 17:29
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaStartApplication.class,args);
    }
}
