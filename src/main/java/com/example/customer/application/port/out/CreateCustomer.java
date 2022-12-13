package com.example.customer.application.port.out;

import com.example.customer.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreateCustomer {

    Customer save(Customer customers);
}
