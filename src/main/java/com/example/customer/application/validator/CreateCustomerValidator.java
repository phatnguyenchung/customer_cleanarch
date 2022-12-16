package com.example.customer.application.validator;

import com.example.customer.application.port.out.GetCustomer;
import com.example.customer.domain.Customer;
import com.example.customer.exception.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class CreateCustomerValidator {

    private GetCustomer getCustomer;

    public void validatorCustomer(Customer command) {
        boolean existById = false;
        if(Objects.nonNull((command.getId()))){
            existById = getCustomer.existById(command.getId());
        }
        if(existById) {
            log.error("exist id customer");
            throw new CustomerExistException();
        }

        boolean existByLegalId = false;
        if(Objects.nonNull(command.getLegalId())  && !command.getLegalId().isEmpty()) {
            existByLegalId= getCustomer.existsByLegalId(command.getLegalId());
        }
        boolean existByPhoneNumber = false;
        if(Objects.nonNull(command.getPhoneNumber()) && !command.getPhoneNumber().isEmpty()){
            existByPhoneNumber = getCustomer.existsByPhoneNumber(command.getPhoneNumber());
        }
        boolean existByPassport = false;
        if(Objects.nonNull(command.getPassport()) && !command.getPassport().isEmpty()){
            existByPassport = getCustomer.existsByPassport(command.getPassport());
        }
        if(existByLegalId){
            log.error("exist legal id customer");
            throw new CustomerLegalIdExistException();
        }
        if(existByPhoneNumber){
            log.error("exist phone number customer");
            throw new CustomerPhoneNumberExistException();
        }
        if(existByPassport){
            log.error("exist passport customer");
            throw new CustomerPassportExistException();
        }
    }
}
