package com.example.springsecurityjwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(SpringSecurityJwtApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        port = port == null ? "8080" : port;
        String path = env.getProperty("server.servlet.context-path");
        path = path == null ? "" : path;
        log.info("\n----------------------------------------------------------\n\t" +
                "项目成功运行! Access URLs:\n\t" +
                "本地访问地址: \thttp://localhost:" + port + path + "/\n\t" +
                "外部访问地址: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger文档: \thttp://localhost:" + port + path + "/swagger-ui/\n" +
                "----------------------------------------------------------");
    }
}
