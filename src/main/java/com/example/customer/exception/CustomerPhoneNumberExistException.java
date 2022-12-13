package com.example.customer.exception;

public class CustomerPhoneNumberExistException extends  RuntimeException{
    public CustomerPhoneNumberExistException() {
        super("Customer phone number existed in database");
    }
}
