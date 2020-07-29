package com.wufeida.remind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.wufeida.remind.dao") //添加 @Mapper 注解
@EnableConfigurationProperties
public class RemindApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemindApplication.class, args);
    }

}
