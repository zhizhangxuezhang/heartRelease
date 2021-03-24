package com.cs.heart_release_01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.cs.heart_release_01.dao")
public class HeartRelease01Application {

    public static void main(String[] args) {
        SpringApplication.run(HeartRelease01Application.class, args);
    }

}
