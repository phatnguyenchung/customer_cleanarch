package com.example.customer.adapter.in;

import com.example.customer.application.port.in.CreateCustomerCommand;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRequest {

    private List<Customer> items;

    @Getter
    @Builder
    public static class Customer {
        private Long id;
        private Long customerId;
        private String customerName;
        private String phoneNumber;
        private String emailAddress;
        private Date bDay;
        private String placeOfBirth;
        private String legalId;
        private String docType;
        private Date docIssueDate;
        private String docIssuePlace;
        private Date docExpiredDate;
        private String Gender;
        private String Passport;
        private Date passportIssueDate;
        private String passportIssuePlace;
        private Date passportExpiredDate;
    }
    public CreateCustomerCommand toCommand(){
        return CreateCustomerCommand.builder()
                .items(items.stream()
                        .map(item -> com.example.customer.domain.Customer.builder()
                                .customerId(item.customerId)
                                .customerName(item.customerName)
                                .Gender(item.Gender)
                                .bDay(item.bDay)
                                .docType(item.docType)
                                .legalId(item.legalId)
                                .docIssueDate(item.docIssueDate)
                                .docExpiredDate(item.docExpiredDate)
                                .docIssuePlace(item.docIssuePlace)
                                .Passport(item.Passport)
                                .passportIssueDate(item.passportIssueDate)
                                .passportExpiredDate(item.passportExpiredDate)
                                .passportIssuePlace(item.passportIssuePlace)
                                .emailAddress(item.emailAddress)
                                .placeOfBirth(item.placeOfBirth)
                                .build())
                        .collect(Collectors.toList()))
                .Id(items.get(0).id)
                .build();
    }
}
