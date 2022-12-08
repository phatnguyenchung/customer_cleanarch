package com.example.customer.application.port.in;

import org.springframework.transaction.annotation.Transactional;

public interface UpdateCustomerUseCase {
    @Transactional
    UpdateCustomerCommandResult update(UpdateCustomerComand comand);
}
