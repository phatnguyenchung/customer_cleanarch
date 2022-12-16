package com.example.customer.exception;

public class CustomerLegalIdExistException extends RuntimeException {
    public CustomerLegalIdExistException() {
        super("Customer legal ID existed in database");
    }
}
