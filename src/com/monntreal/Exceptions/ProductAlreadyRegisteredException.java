package com.monntreal.Exceptions;

public class ProductAlreadyRegisteredException extends Exception {
    public ProductAlreadyRegisteredException(){
        super("product already registered");
    }
}
