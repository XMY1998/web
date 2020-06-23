package com.dhl.android;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan("com.dhl.android.mapper")
@SpringBootApplication
public class AndroidApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndroidApplication.class, args);
    }

}
