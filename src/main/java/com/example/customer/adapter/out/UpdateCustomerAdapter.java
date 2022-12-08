package com.example.customer.adapter.out;

import com.example.customer.application.port.in.UpdateCustomerComand;
import com.example.customer.application.port.out.UpdateCustomer;
import com.example.customer.domain.Customer;
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
    public int update(Long customerId, Long id, UpdateCustomerComand comand) {
        CustomerJpaEntity customerJpaEntities = repository.findByCustomerIdAndId(customerId, id).orElse(null);
        customerJpaEntities.setId(comand.getId());
        customerJpaEntities.setCustomerId(comand.getCustomerId());
        customerJpaEntities.setCustomerName(comand.getCustomerName());
        customerJpaEntities.setPhoneNumber(comand.getPhoneNumber());
        customerJpaEntities.setEmailAddress(comand.getEmailAddress());
        customerJpaEntities.setBDay(comand.getBDay());
        customerJpaEntities.setPlaceOfBirth(comand.getPlaceOfBirth());
        customerJpaEntities.setLegalId(comand.getLegalId());
        customerJpaEntities.setDocType(comand.getDocType());
        customerJpaEntities.setDocIssueDate(comand.getDocIssueDate());
        customerJpaEntities.setDocIssuePlace(comand.getDocIssuePlace());
        customerJpaEntities.setDocExpiredDate(comand.getDocExpiredDate());
        customerJpaEntities.setGender(comand.getGender());
        customerJpaEntities.setPassport(comand.getPassport());
        customerJpaEntities.setPassportIssueDate(comand.getPassportIssueDate());
        customerJpaEntities.setPassportIssuePlace(comand.getPassportIssuePlace());
        customerJpaEntities.setPassportExpiredDate(comand.getPassportExpiredDate());
        repository.save(customerJpaEntities);
        return 0;
    }
}
