package com.maodot.springcloud.springcloudhystrix.controller;

import com.maodot.springcloud.springcloudhystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MAODOT
 */
@RestController
public class HiController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/ribbon/hystrix/hi" , method = {RequestMethod.GET})
    public String hi(@RequestParam("name") String name){
        return helloService.hiService(name);
    }

}
