package com.example.springsecurityjwt.config;


import com.example.springsecurityjwt.domain.AdminUserDetails;
import com.example.springsecurityjwt.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @auther shenwan
 * @description 自定义配置，用于配置如何获取用户信息
 * @date 2022/5/20
 */
@Configuration
public class UserSecurityConfig {
    @Autowired
    private UmsAdminService adminService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            AdminUserDetails admin = adminService.getAdminByUsername(username);
            if (admin != null) {
                return admin;
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }
}
