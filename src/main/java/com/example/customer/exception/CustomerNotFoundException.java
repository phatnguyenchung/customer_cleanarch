package com.example.customer.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Long id){
        super("Could not find customer:" + id);
    }


    public CustomerNotFoundException(){
        super("No data");
    }
}
