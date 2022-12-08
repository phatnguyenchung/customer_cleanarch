package com.example.customer.application.port.out;

import com.example.customer.adapter.out.CustomerJpaEntity;
import com.example.customer.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetCustomer {
    List<Customer> getAllCustomer();

    Customer getByIdAndCustomerId(long id,long customerId);

    boolean existsByIdOrLegalIdOrPassportOrPhoneNumber(Long id, String legalId, String passport, String phoneNumber);
}
