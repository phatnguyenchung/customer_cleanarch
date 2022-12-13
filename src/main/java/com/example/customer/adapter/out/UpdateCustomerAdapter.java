package com.example.customer.adapter.out;

import com.example.customer.application.port.in.UpdateCustomerComand;
import com.example.customer.application.port.out.UpdateCustomer;
import com.example.customer.domain.Customer;
import jdk.internal.module.ModuleLoaderMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomer {
    @Autowired
    private final JpaCustomerRepository repository;
    @Override
    public int update(Customer customer) {
        repository.save(CustomerMapper.mapToJpaEntity(customer));
        return 0;
    }
}
