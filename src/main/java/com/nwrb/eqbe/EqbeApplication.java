package com.nwrb.eqbe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nwrb.eqbe.mapper")
public class EqbeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EqbeApplication.class, args);
    }

}
