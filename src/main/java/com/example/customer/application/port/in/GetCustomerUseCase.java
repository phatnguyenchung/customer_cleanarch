package com.example.customer.application.port.in;

import com.example.customer.domain.Customer;

import java.util.List;

public interface GetCustomerUseCase {

    List<Customer> getCustomer();

    Customer getCustomerById(long id);

    Customer getCustomerByUserId(long customerId);

    Customer getCustomerByName(String customerName);
}
