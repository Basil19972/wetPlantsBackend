package com.example.WetPlant.core.exception;

public class EmailAlreadyExists extends RuntimeException{

    public EmailAlreadyExists(String errorMessage){
        super(errorMessage);
    }
}
