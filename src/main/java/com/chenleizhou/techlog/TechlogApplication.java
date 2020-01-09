package com.chenleizhou.techlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.chenleizhou.techlog.mapper")
@SpringBootApplication
@EnableCaching
public class TechlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechlogApplication.class, args);
    }

}