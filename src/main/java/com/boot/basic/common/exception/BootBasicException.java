package com.boot.basic.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BootBasicException extends Exception {
    private static final long serialVersionUID = 4663388340591151694L;

    private Exceptions exceptions;
    private HttpStatus httpStatus;

    public BootBasicException(Exceptions exceptions, HttpStatus status, String message){
        super(exceptions.toString() + message);
        this.exceptions = exceptions;
        this.httpStatus = status;
    }

    public int getHttpStatusCode(){
        return httpStatus.value();
    }

    public String getHttpStatusType(){
        return httpStatus.getReasonPhrase();
    }
}
