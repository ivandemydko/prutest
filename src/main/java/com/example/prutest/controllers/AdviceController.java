package com.example.prutest.controllers;

import com.example.prutest.exceptions.LengthValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LengthValidationException.class)
   public String lengthExceptionHandler(LengthValidationException l) {
        return l.getMessage();
    }
}
