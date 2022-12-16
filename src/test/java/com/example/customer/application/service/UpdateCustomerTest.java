package com.example.customer.application.service;

import com.example.customer.application.port.in.UpdateCustomerComand;
import com.example.customer.application.port.in.UpdateCustomerCommandResult;
import com.example.customer.application.port.out.GetCustomer;
import com.example.customer.application.port.out.UpdateCustomer;
import com.example.customer.application.service.customer.UpdateCustomerService;
import com.example.customer.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class UpdateCustomerTest {
    @Mock
    private UpdateCustomer updateCustomer;

    @InjectMocks
    private UpdateCustomerService updateCustomerService;

    @Captor
    private ArgumentCaptor<Customer> customerCaptor;

    @Mock
    private GetCustomer getCustomer;

    @Test
    public void testUpdateCustonmer() {
        Date currentDate = new Date();
        UpdateCustomerComand updateCustomerComand = UpdateCustomerComand.builder()
                .Id(1L)
                .customerId(1L)
                .customerName("Alex")
                .phoneNumber("09039039289")
                .emailAddress("alex@cuibap.timo.vn")
                .bDay(currentDate)
                .placeOfBirth("Nha Trang")
                .legalId("2378782389")
                .docType("CCCD")
                .docIssuePlace("Ho Chi Minh")
                .docIssueDate(currentDate)
                .docExpiredDate(currentDate)
                .Passport("293829238")
                .passportIssueDate(currentDate)
                .passportIssuePlace("Ho Chi Minh")
                .passportExpiredDate(currentDate)
                .Gender("1")
                .build();

        Customer item = Customer.builder()
                .Id(1L)
                .customerId(1L)
                .customerName("Alex")
                .phoneNumber("09039039289")
                .emailAddress("alex@cuibap.timo.vn")
                .bDay(currentDate)
                .placeOfBirth("Nha Trang")
                .legalId("2378782389")
                .docType("CCCD")
                .docIssuePlace("Ho Chi Minh")
                .docIssueDate(currentDate)
                .docExpiredDate(currentDate)
                .Passport("293829238")
                .passportIssueDate(currentDate)
                .passportIssuePlace("Ho Chi Minh")
                .passportExpiredDate(currentDate)
                .Gender("1")
                .build();

        Mockito.when(updateCustomer
                        .update(Mockito.any()))
                .thenReturn(1);
        //Get
        Mockito.when(getCustomer.getCustomerById(Mockito.anyLong()))
                .thenReturn(item);
        //WHEN
        UpdateCustomerCommandResult result = updateCustomerService.update(updateCustomerComand);

        //THEN
        Assertions.assertEquals(true, result.isStatus());
        Mockito.verify(updateCustomer).update(customerCaptor.capture());
        Customer capturedValue = customerCaptor.getValue();
        Assertions.assertEquals(1, capturedValue.getCustomerId());
        Assertions.assertEquals(1, capturedValue.getId());
        Assertions.assertEquals("Alex", capturedValue.getCustomerName());
        Assertions.assertEquals("09039039289", capturedValue.getPhoneNumber());
        Assertions.assertEquals("alex@cuibap.timo.vn", capturedValue.getEmailAddress());
        Assertions.assertEquals(currentDate, capturedValue.getBDay());
        Assertions.assertEquals("Nha Trang", capturedValue.getPlaceOfBirth());
        Assertions.assertEquals("2378782389", capturedValue.getLegalId());
        Assertions.assertEquals("CCCD", capturedValue.getDocType());
        Assertions.assertEquals(currentDate, capturedValue.getDocIssueDate());
        Assertions.assertEquals(currentDate, capturedValue.getDocExpiredDate());
        Assertions.assertEquals("293829238", capturedValue.getPassport());
        Assertions.assertEquals(currentDate, capturedValue.getPassportIssueDate());
        Assertions.assertEquals("Ho Chi Minh", capturedValue.getPassportIssuePlace());
        Assertions.assertEquals(currentDate, capturedValue.getPassportExpiredDate());
        Assertions.assertEquals("1", capturedValue.getGender());
    }
}
