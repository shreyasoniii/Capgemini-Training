package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(FizzException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public GlobalError handleFizzException(FizzException ex) {
        return new GlobalError(ex.getMessage(),ex.getErrorReason());
    }
    @ResponseBody
    @ExceptionHandler(BuzzException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalError handleBuzzException(BuzzException ex) {
        return new GlobalError(ex.getMessage(),ex.getErrorReason());
    }
    @ResponseBody
    @ExceptionHandler(FizzBuzzException.class)
    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    public GlobalError handleFizzBuzzException(FizzBuzzException ex){
        return new GlobalError(ex.getMessage(),ex.getErrorReason());
    }
}
