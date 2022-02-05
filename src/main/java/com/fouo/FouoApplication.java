package com.fouo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("com.fouo.*")
public class FouoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FouoApplication.class, args);
    }
}
