package com.lcwd.todomanager.todomanager.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(NullPointerException.class)
    public String getException(NullPointerException ex){
        return ex.getMessage();

    }

}
