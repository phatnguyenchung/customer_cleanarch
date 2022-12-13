package com.example.customer.exception;

public class CustomerExistException extends RuntimeException {
    public CustomerExistException() {
        super("Customer existed in database");
    }

}
