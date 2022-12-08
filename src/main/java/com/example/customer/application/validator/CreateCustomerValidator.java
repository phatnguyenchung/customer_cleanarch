package com.example.customer.application.validator;

import com.example.customer.application.port.in.CreateCustomerCommand;
import com.example.customer.application.port.in.CustomerCommand;
import com.example.customer.application.port.out.GetCustomer;
import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerExistException;
import com.example.customer.exception.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class CreateCustomerValidator {

    private GetCustomer getCustomer;

    public void validatorCustomer(CreateCustomerCommand command){
        boolean exist = getCustomer.existsByIdOrLegalIdOrPassportOrPhoneNumber(command.getCustomerId(), command.getLegalId(), command.getPassport(), command.getPhoneNumber());
        if(exist){
            log.error("exist customer");
            throw new CustomerExistException();
        }
    }
}
