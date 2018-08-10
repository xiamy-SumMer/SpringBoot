package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author SumMer
 * @version V1.0
 * @Title: App
 * @Package com.example
 * @Description: SpringBoot启动类
 * @date 2018-08-08 09:24
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(App.class);
    }
}
