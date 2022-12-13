package com.example.customer.application.port.out;

import com.example.customer.application.port.in.UpdateCustomerComand;
import com.example.customer.domain.Customer;

public interface UpdateCustomer {
    int update(Customer customer);
}
