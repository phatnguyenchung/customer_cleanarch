package com.example.customer.application.service.customer;

import com.example.customer.adapter.out.CustomerJpaEntity;
import com.example.customer.application.port.in.GetCustomerUseCase;
import com.example.customer.application.port.out.GetCustomer;
import com.example.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements GetCustomerUseCase {
    private final GetCustomer getCustomer;

    @Override
    public List<Customer> getCustomer(){
       return getCustomer.getAllCustomer();
    }

}
