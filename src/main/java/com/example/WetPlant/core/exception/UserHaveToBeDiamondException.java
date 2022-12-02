package com.example.WetPlant.core.exception;

public class UserHaveToBeDiamondException extends RuntimeException{

    public UserHaveToBeDiamondException(String errorMessage){
        super(errorMessage);
    }
}
