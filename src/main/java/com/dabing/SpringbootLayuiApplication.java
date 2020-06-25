package com.dabing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dabing.mapper")
public class SpringbootLayuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLayuiApplication.class, args);
    }

}
