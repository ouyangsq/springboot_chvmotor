package com.kirb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kirb.dao")
public class SpringbootChvmotorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootChvmotorApplication.class, args);
    }

}
