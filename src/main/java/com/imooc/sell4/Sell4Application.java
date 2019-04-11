package com.imooc.sell4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@MapperScan(basePackages = "com.imooc.sell4.dataobject.mapper")
@EnableCaching
public class Sell4Application {

    public static void main(String[] args) {
        SpringApplication.run(Sell4Application.class, args);
    }

}
