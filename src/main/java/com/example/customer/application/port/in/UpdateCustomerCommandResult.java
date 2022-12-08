package com.example.customer.application.port.in;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateCustomerCommandResult {
    private boolean status;
}
