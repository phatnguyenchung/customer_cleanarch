package com.example.customer.adapter.out;

import com.example.customer.application.port.out.CreateCustomer;
import com.example.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateCustomerApdapter implements CreateCustomer {
    private final JpaCustomerRepository repository;

    @Override
    public Customer save(Customer customers) {
        return CustomerMapper.mapToDomainEntity(repository.save(CustomerMapper.mapToJpaEntity(customers)));
    }
}
