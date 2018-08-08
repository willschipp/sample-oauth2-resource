package com.example.telco.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class SimpleService {

    @RequestMapping(method= RequestMethod.GET)
    public String getHello() throws Exception {
        return "hello";
    }
}
