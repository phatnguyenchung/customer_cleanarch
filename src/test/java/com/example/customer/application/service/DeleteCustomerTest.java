package com.example.customer.application.service;

import com.example.customer.adapter.out.CustomerJpaEntity;
import com.example.customer.adapter.out.JpaCustomerRepository;
import com.example.customer.application.port.in.DeleteCustomerCommandResult;
import com.example.customer.application.port.in.UpdateCustomerCommandResult;
import com.example.customer.application.port.out.DeleteCustomer;
import com.example.customer.application.service.customer.DeleteCustomerService;
import com.example.customer.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;


@ExtendWith(MockitoExtension.class)
public class DeleteCustomerTest {

    @Mock
    private DeleteCustomer deleteCustomer;

    @InjectMocks
    private DeleteCustomerService deleteCustomerService;

    private JpaCustomerRepository jpaCustomerRepository;
    @Captor
    private ArgumentCaptor<Long> customerCaptor;
    @Test
    @Rollback(value = false)
    public void testDeleteCustomer() throws Exception{
        //WHEN
        DeleteCustomerCommandResult result = deleteCustomerService.delete(1L);
        //THEN
        Mockito.verify(deleteCustomer).delete(customerCaptor.capture());
        Assertions.assertTrue(result.isStatus());
        Assertions.assertEquals(1,customerCaptor.getValue());
    }
}
