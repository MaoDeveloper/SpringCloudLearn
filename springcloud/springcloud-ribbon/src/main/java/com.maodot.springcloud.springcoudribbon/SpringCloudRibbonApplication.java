package com.maodot.springcloud.springcoudribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * ribbon 是一个负载均衡客户端
 * 服务消费者（rest+ribbon）(Finchley版本)
 *
 * @author MAODOT
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringCloudRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonApplication.class,args);
    }

    /**
     * 在工程的启动类中,通过@EnableDiscoveryClient向服务中心注册；并且向程序的ioc注入一个bean: restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
