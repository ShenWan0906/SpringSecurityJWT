package com.example.springsecurityjwt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther shenwan
 * @description MyBatis配置类
 * @date 2019/4/8
 */
@Configuration
@MapperScan("com.example.springsecurityjwt.mbg.mapper")
public class MyBatisConfig {
}
