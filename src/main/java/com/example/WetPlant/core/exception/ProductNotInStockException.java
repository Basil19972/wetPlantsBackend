package com.example.WetPlant.core.exception;

public class ProductNotInStockException extends RuntimeException{

    public ProductNotInStockException(String errorMessage){
        super(errorMessage);
    }
}
