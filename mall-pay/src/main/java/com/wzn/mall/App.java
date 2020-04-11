package com.wzn.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }


    @GetMapping("/test")
    public String test(int a){
    return "success";
    }
}
