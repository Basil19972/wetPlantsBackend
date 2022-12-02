package com.example.WetPlant.core.exception;

public class CantDeleteAdminException extends RuntimeException{

    public CantDeleteAdminException(String errorMessage){
        super(errorMessage);
    }
}
