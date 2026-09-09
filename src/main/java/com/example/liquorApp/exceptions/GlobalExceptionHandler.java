package com.example.liquorApp.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler 
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
