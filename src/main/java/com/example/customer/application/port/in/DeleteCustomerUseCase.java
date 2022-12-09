package com.example.customer.application.port.in;

public interface DeleteCustomerUseCase {

    DeleteCustomerCommandResult delete(Long customerId);
}
