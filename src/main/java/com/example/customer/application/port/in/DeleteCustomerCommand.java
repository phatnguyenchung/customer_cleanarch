package com.example.customer.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DeleteCustomerCommand {
    private Long Id;

}
