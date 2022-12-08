package com.example.customer.exception;

public class CustomerDeleteException extends RuntimeException {
    public CustomerDeleteException() {
        super("Customer is not exists in db to delete");
    }
}
