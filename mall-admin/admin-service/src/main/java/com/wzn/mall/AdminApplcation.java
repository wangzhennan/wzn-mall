package com.wzn.mall;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wzn.mall.mapper")
public class AdminApplcation {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplcation.class, args);
    }
}
