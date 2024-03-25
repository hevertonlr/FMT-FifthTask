package com.fmt.app.tutoring.handlers;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
