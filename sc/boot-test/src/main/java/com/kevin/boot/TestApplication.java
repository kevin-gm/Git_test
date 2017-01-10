package com.kevin.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by Administrator on 2016/12/19 0019.
 */
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        //启动方式一：
        SpringApplication.run(TestApplication.class);
        //启动方式二：
       // SpringApplication app = new SpringApplication(TestApplication.class);
        //app.setBanner(null);
        //app.run(args);
        //启动方式三：
        //new SpringApplicationBuilder(TestApplication.class).banner(null).run(args);
    }
}