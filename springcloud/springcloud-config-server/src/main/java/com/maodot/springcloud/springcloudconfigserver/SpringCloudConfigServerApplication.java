package com.maodot.springcloud.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 启动类
 *
 * 在程序的入口Application类加上@EnableConfigServer注解开启配置服务器的功能
 *
 * @author MAODOT
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class,args);
    }

}
