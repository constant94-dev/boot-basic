package com.boot.basic.controller;

import com.boot.basic.dto.MemberDTO;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GetController {

    @GetMapping("/name")
    public String getName(){
        return "Sen";
    }

    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    @GetMapping("/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organic
    ){
        return name + " " + email + " " + organic;
    }

    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> params){
        StringBuilder sb = new StringBuilder();

        params.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : "+map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
