package com.notlarim.notlarimltd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan( {"utility", "com.notlarim.notlarimltd"})
public class NotlarimLtdApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotlarimLtdApplication.class, args);
    }

}
