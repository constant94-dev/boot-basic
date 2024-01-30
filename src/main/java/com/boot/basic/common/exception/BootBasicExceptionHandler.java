package com.boot.basic.common.exception;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * RestController 단에서 발생하는 에러를 이 클래스에서 catch 하여 처리한다
 */
@RestControllerAdvice
public class BootBasicExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(BootBasicExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String,String>> exceptionHandler(Exception e){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        LOGGER.info("Advice 내 ExceptionHandler 호출!");

        Map<String,String> maps = new HashMap<>();
        maps.put("error type",status.getReasonPhrase());
        maps.put("code","400");
        maps.put("message","에러 발생");

        return new ResponseEntity<>(maps, headers,status);
    }

    @ExceptionHandler(value = BootBasicException.class)
    public ResponseEntity<Map<String,String>> exceptionHandler(BootBasicException e){
        HttpHeaders headers = new HttpHeaders();

        Map<String,String> maps = new HashMap<>();
        maps.put("error type",e.getHttpStatusType());
        maps.put("error code",Integer.toString(e.getHttpStatusCode()));
        maps.put("message",e.getMessage());

        return new ResponseEntity<>(maps,headers,e.getHttpStatus());
    }
}
