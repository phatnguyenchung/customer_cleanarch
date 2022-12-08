package com.example.customer.application.port.in;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteCustomerCommandResult {
    private boolean status;
}
