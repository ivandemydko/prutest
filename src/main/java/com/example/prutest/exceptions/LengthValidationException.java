package com.example.prutest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This is a bad request....")
public class LengthValidationException extends RuntimeException {

    public LengthValidationException(String message) {
         super(message);
    }
}
