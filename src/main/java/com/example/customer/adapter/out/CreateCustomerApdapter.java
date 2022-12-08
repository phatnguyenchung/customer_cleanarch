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
    public List<Customer> save(List<Customer> customers) {
        List<CustomerJpaEntity> entities =
                customers.stream().map(CustomerMapper::mapToJpaEntity).collect(Collectors.toList());
        return repository.saveAll(entities).stream()
                .map(CustomerMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
