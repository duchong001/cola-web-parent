package com.duchong.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 * @author Frank Zhang
 */
@MapperScan(basePackages = "com.duchong.demo.**.mapper")
@SpringBootApplication(scanBasePackages = {"com.duchong.demo", "com.alibaba.cola.*"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
