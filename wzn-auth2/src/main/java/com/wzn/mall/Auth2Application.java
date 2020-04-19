package com.wzn.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@RestController
@MapperScan("com.wzn.mall")
public class Auth2Application {
    public static void main( String[] args ) {
        SpringApplication.run(Auth2Application.class,args);
    }
    @RequestMapping("/wzn/r1")
    public String test(){
        return "wzn";
    }

    @RequestMapping("/wzn/r2")
    public String test1(){
        return "wzn1";
    }
}
