package com.example.customer.application.port.in;

import com.example.customer.adapter.out.CustomerJpaEntity;
import com.example.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface GetCustomerUseCase {

    List<Customer> getCustomer();

    Customer getCustomerById(long id);

    Customer getCustomerByUserId(long customerId);
}
