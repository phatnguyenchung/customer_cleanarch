package com.example.customer.application.port.in;

import com.example.customer.domain.Customer;

import java.util.List;

public interface CreateCustomerUseCase {
    List<Customer> create(CreateCustomerCommand command);
}
