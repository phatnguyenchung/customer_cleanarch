package com.example.customer.application.port.in;

import com.example.customer.domain.Customer;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CustomerCommandResult {
    private boolean status;
}
