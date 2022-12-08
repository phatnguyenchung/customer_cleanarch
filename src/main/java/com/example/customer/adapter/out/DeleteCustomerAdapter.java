package com.example.customer.adapter.out;

import com.example.customer.application.port.out.DeleteCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerAdapter implements DeleteCustomer {
    @Autowired
    private final JpaCustomerRepository repository;

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
