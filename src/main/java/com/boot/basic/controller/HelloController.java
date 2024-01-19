package com.boot.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 스프링 4.0버전 부터 사용
public class HelloController {

    /*
     고전적인 방법
     @RequestMapping(value = "/hello", method = RequestMethod.GET)
    */
    // spring 4.3버전 부터 사용
    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
