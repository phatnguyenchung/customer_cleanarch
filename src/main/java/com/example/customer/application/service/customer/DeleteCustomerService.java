package com.example.customer.application.service.customer;

import com.example.customer.application.port.in.DeleteCustomerCommandResult;
import com.example.customer.application.port.in.DeleteCustomerUseCase;
import com.example.customer.application.port.out.DeleteCustomer;
import com.example.customer.exception.CustomerDeleteException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeleteCustomerService implements DeleteCustomerUseCase {
    private final DeleteCustomer deleteCustomer;

    @Override
    public DeleteCustomerCommandResult delete(Long id) {
        try {
            deleteCustomer.delete(id);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(new CustomerDeleteException());
        }
    }
}
