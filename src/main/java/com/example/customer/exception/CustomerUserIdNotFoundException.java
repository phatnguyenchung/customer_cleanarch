package com.example.customer.exception;

public class CustomerUserIdNotFoundException extends RuntimeException {
    public CustomerUserIdNotFoundException(Long userId) {
        super("Could not find customer:" + userId);
    }
}
