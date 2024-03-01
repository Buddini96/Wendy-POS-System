package com.wendy.backend.exception;

/**
 * @author Buddini
 * Created on 01 Mar, 2024
 */
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer id){
        super("Could not found the Product with id " + id);
    }
}
