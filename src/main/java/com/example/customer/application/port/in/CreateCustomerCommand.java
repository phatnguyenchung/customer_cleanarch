package com.example.customer.application.port.in;

import com.example.customer.domain.Customer;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;
@Getter
@Builder
public class CreateCustomerCommand {
    private List<Customer> items;
    private long customerId;

    private String legalId;

    private String passport;

    private String phoneNumber;
}
