package com.example.liquorApp.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException (String message){
        super(message);
    }
}
