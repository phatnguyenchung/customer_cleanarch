package com.example.customer.adapter.out;

import com.example.customer.domain.Customer;

public class CustomerMapper {

    public static CustomerJpaEntity mapToJpaEntity(Customer value){
        return CustomerJpaEntity.builder()
                .id(value.getId())
                .customerId(value.getCustomerId())
                .customerName(value.getCustomerName())
                .bDay(value.getBDay())
                .gender(value.getGender())
                .emailAddress(value.getEmailAddress())
                .docType(value.getDocType())
                .legalId(value.getLegalId())
                .docIssuePlace(value.getDocIssuePlace())
                .docIssueDate(value.getDocIssueDate())
                .docExpiredDate(value.getDocExpiredDate())
                .passport(value.getPassport())
                .passportIssuePlace(value.getPassportIssuePlace())
                .passportIssueDate(value.getPassportIssueDate())
                .passportExpiredDate(value.getPassportExpiredDate())
                .placeOfBirth(value.getPlaceOfBirth())
                .phoneNumber(value.getPhoneNumber())
                .build();
    }

    public static Customer mapToDomainEntity(CustomerJpaEntity value){
        return Customer.builder()
                .Id(value.getId())
                .customerId(value.getCustomerId())
                .customerName(value.getCustomerName())
                .phoneNumber(value.getPhoneNumber())
                .emailAddress(value.getEmailAddress())
                .bDay(value.getBDay())
                .placeOfBirth(value.getPlaceOfBirth())
                .legalId(value.getLegalId())
                .docType(value.getDocType())
                .docIssuePlace(value.getDocIssuePlace())
                .docIssueDate(value.getDocIssueDate())
                .docExpiredDate(value.getDocExpiredDate())
                .Gender(value.getGender())
                .Passport(value.getPassport())
                .passportIssuePlace(value.getPassportIssuePlace())
                .passportIssueDate(value.getPassportIssueDate())
                .passportExpiredDate(value.getPassportExpiredDate())
                .build();
    }
}
