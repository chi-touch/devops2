package com.devOps2.devops2.exceptions;

public class ThisUserAlreadyExistException extends RuntimeException{
    public ThisUserAlreadyExistException(String message){
        super(message);
    }
}
