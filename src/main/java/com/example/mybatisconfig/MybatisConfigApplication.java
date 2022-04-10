package com.example.mybatisconfig;

import com.example.mybatisconfig.config.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync  //开启异步任务
@SpringBootApplication
public class MybatisConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisConfigApplication.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
