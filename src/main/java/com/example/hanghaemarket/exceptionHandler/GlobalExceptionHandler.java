package com.example.hanghaemarket.exceptionHandler;

import com.example.hanghaemarket.dto.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ErrorMessage exception(Exception e){
        return ErrorMessage.builder()
                .errorMsg(e.getLocalizedMessage())
                .build();
    }

}
