package com.example.customer.exception;

public class CustomerDeleteException extends RuntimeException{
    public CustomerDeleteException(){
        super("No data to delete");
    }
}
