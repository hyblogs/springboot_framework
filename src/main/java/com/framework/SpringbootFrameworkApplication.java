package com.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.framework.mapper")
public class SpringbootFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFrameworkApplication.class, args);
    }

}
