package com.example.exe1.controller;

import com.example.exe1.exception.EmptyException;
import com.example.exe1.exception.NotFoundCodeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EmptyException.class)
    public String errorPage(){
        return "book/errorPage";
    }

    @ExceptionHandler({NotFoundCodeException.class, NumberFormatException.class})
    public String errorPage2(){
        return "book/errorPage2";
    }
}
