package com.example.WetPlant.core.exception;

public class UserNot18Exception extends RuntimeException{

    public UserNot18Exception(String errorMessage){
        super(errorMessage);
    }
}
