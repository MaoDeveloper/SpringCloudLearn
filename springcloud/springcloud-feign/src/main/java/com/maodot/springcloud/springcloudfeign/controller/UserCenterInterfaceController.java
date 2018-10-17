package com.maodot.springcloud.springcloudfeign.controller;

import com.maodot.springcloud.springcloudfeign.service.UserCenterInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCenterInterfaceController {

    @Autowired
    private UserCenterInterfaceService userCenterService;

    /**
     * 在Web层的controller层，对外暴露一个"/user/say/hi"的API接口，通过上面定义的Feign客户端UserCenterInterfaceService 来消费服务
     * @param name
     * @return
     */
    @RequestMapping("/user/say/hi")
    public String sayHi(@RequestParam(name = "name")String name){
        return userCenterService.sayHiFromClientOne(name);
    }

}
