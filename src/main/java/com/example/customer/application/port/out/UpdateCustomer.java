package com.example.customer.application.port.out;

import com.example.customer.application.port.in.UpdateCustomerComand;

public interface UpdateCustomer {
    int update(Long customerId, Long id, UpdateCustomerComand comand);
}
