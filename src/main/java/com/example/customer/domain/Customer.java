package com.example.customer.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@Slf4j
@ToString
@AllArgsConstructor
@Builder
public class Customer {
    private Long Id;
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
