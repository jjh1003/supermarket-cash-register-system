package com.zlx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zlx.dao")
public class SupermarketCashRegisterSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermarketCashRegisterSystemApplication.class, args);
    }

}
