package com.example.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException ex){
        return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
    }
    
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidationError(MethodArgumentNotValidException exception){
        List<Map<String,String>> errorList=new ArrayList<>();
        List<FieldError>fieldErrors=exception.getBindingResult().getFieldErrors();
        for (FieldError error:fieldErrors){
            Map<String,String> err=new HashMap<>();
            err.put("field",error.getField());
            err.put("message",error.getDefaultMessage());
            errorList.add(err);
        }
        Map<String,Object>response=new HashMap<>();
        response.put("errors",errorList);
        return response;
    }
    

    
}
