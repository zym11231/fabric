package com.example.fabric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //支持servlet组件
@SpringBootApplication
public class FabricApplication {

    public static void main(String[] args) {
        SpringApplication.run(FabricApplication.class, args);
    }

}
