package com.example.customer.exception;

public class CustomerNameNotFoundException extends RuntimeException{
    public CustomerNameNotFoundException(String customerName) {
        super("Could not find customer:" + customerName);
    }
}
