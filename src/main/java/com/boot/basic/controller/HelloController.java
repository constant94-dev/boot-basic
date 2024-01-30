package com.boot.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 스프링 4.0버전 부터 사용
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /*
     고전적인 방법
     @RequestMapping(value = "/hello", method = RequestMethod.GET)
    */
    // spring 4.3버전 부터 사용
    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @PostMapping("/exception")
    public void exceptionTest() throws Exception{
        throw new Exception("예외 생짜 던지기!");
    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<Map<String,String>> exceptionHandler(Exception e){
//        HttpHeaders headers = new HttpHeaders();
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//
//        LOGGER.info(e.getMessage());
//        LOGGER.info("HelloController 내 ExceptionHandler 호출!");
//
//        Map<String,String> maps = new HashMap<>();
//        maps.put("error type",status.getReasonPhrase());
//        maps.put("code","400");
//        maps.put("message","에러 발생");
//
//        return new ResponseEntity<>(maps, headers,status);
//    }

    @PostMapping("/log-test")
    public void logTest(){
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");
    }
}
