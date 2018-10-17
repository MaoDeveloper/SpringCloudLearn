package com.maodot.springcloud.springcloudfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户中心接口调用服务
 *
 *  Feign 采用的是基于接口的注解
 *  Feign 整合了ribbon，具有负载均衡的能力
 *  整合了Hystrix，具有熔断的能力
 *
 * @author MAODOT
 */
@FeignClient(value = "user-center")
public interface UserCenterInterfaceService {

    // @ FeignClient（“服务名”），来指定调用哪个服务

    @RequestMapping(value = "/hi",method = {RequestMethod.GET})
    String sayHiFromClientOne(@RequestParam(name = "name") String name);
}
