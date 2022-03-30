package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.example.demo.mapper")
@SpringBootApplication()
public class ShardingSphereMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereMybatisplusApplication.class, args);
    }

}
