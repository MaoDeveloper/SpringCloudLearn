package com.maodot.springcloud.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigController {

    @Value("${hello}")
    private String hello;

    @RequestMapping("/say/hello")
    public String sayHello(){
        return hello;
    }
}
