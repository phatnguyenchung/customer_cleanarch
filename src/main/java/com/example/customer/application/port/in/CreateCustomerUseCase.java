package com.example.customer.application.port.in;

public interface CreateCustomerUseCase {
    CreateCustomerCommandResult create(CreateCustomerCommand command);
}
