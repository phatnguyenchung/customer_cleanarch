package com.example.customer.application.service.customer;

import com.example.customer.application.port.in.CreateCustomerCommand;
import com.example.customer.application.port.in.CreateCustomerCommandResult;
import com.example.customer.application.port.in.CreateCustomerUseCase;
import com.example.customer.application.port.out.CreateCustomer;
import com.example.customer.application.validator.CreateCustomerValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateCustomerService implements CreateCustomerUseCase {

    private final CreateCustomer createCustomer;
    private final CreateCustomerValidator validator;
    @Override
    public CreateCustomerCommandResult create(CreateCustomerCommand command){
        validator.validatorCustomer(command);
        return CreateCustomerCommandResult.builder()
                .items(createCustomer.save(command.getItems()))
                .build();
    }
}
