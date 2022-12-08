package com.example.customer.application.service.customer;

import com.example.customer.application.port.in.UpdateCustomerComand;
import com.example.customer.application.port.in.UpdateCustomerCommandResult;
import com.example.customer.application.port.in.UpdateCustomerUseCase;
import com.example.customer.application.port.out.GetCustomer;
import com.example.customer.application.port.out.UpdateCustomer;
import com.example.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UpdateCustomerService implements UpdateCustomerUseCase {
    private final UpdateCustomer updateCustomer;
    private final GetCustomer getCustomer;


    @Override
    @Transactional
    public UpdateCustomerCommandResult update(UpdateCustomerComand comand){
        Customer customer = getCustomer.getByIdAndCustomerId(comand.getId(),comand.getCustomerId());
        customer.setCustomerName(comand.getCustomerName());
        customer.setPhoneNumber(comand.getPhoneNumber());
        customer.setEmailAddress(comand.getEmailAddress());
        customer.setBDay(comand.getBDay());
        customer.setPlaceOfBirth(comand.getPlaceOfBirth());
        customer.setLegalId(comand.getLegalId());
        customer.setDocType(comand.getDocType());
        customer.setDocIssueDate(comand.getDocIssueDate());
        customer.setDocIssuePlace(comand.getDocIssuePlace());
        customer.setDocExpiredDate(comand.getDocExpiredDate());
        customer.setGender(comand.getGender());
        customer.setPassport(comand.getPassport());
        customer.setPassportIssueDate(comand.getPassportIssueDate());
        customer.setPassportIssuePlace(comand.getPassportIssuePlace());
        customer.setPassportExpiredDate(comand.getPassportExpiredDate());
        updateCustomer.update(comand.getCustomerId(), comand.getId(), comand);
        return null;
    }
}
