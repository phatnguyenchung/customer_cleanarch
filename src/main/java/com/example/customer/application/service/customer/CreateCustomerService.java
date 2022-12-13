package com.example.customer.application.service.customer;

import com.example.customer.application.port.in.CreateCustomerCommand;
import com.example.customer.application.port.in.CreateCustomerCommandResult;
import com.example.customer.application.port.in.CreateCustomerUseCase;
import com.example.customer.application.port.out.CreateCustomer;
import com.example.customer.application.validator.CreateCustomerValidator;
import com.example.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateCustomerService implements CreateCustomerUseCase {

    private CreateCustomer createCustomer;
    private final CreateCustomerValidator validator;

    @Override
    public List<Customer> create(CreateCustomerCommand command) {

        List<Customer> lstCustomer = command.getItems();
        List<Customer> rs = new ArrayList<>();
        for(Customer item : lstCustomer) {
            validator.validatorCustomer(item);
            rs.add(createCustomer.save(item));
        }
        return rs;
    }
}
