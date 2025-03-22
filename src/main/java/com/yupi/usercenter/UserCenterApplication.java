package com.yupi.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yupi.usercenter.mapper")
public class UserCenterApplication {

    public static void main(String[] args) {
        System.out.println("hello world");
        SpringApplication.run(UserCenterApplication.class, args);
    }

}
