package com.example.customer.exception;

public class CustomerPassportExistException extends RuntimeException{
    public CustomerPassportExistException() {
        super("Customer passport existed in database");
    }

}
