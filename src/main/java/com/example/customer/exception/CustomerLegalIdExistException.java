package com.example.customer.exception;

public class CustomerLegalIdExistException extends Exception {
    public CustomerLegalIdExistException() {
        super("Customer legal ID existed in database");
    }
}
