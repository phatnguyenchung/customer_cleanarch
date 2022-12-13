package com.example.customer.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class UpdateCustomerComand {


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
