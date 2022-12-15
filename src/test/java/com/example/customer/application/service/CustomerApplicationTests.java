package com.example.customer.application.service;

import com.example.customer.adapter.out.JpaCustomerRepository;
import com.example.customer.application.port.in.CreateCustomerCommand;
import com.example.customer.application.port.in.UpdateCustomerComand;
import com.example.customer.application.port.in.UpdateCustomerCommandResult;
import com.example.customer.application.port.out.CreateCustomer;
import com.example.customer.application.port.out.UpdateCustomer;
import com.example.customer.application.service.customer.CreateCustomerService;
import com.example.customer.application.service.customer.UpdateCustomerService;
import com.example.customer.application.validator.CreateCustomerValidator;
import com.example.customer.domain.Customer;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import javax.swing.plaf.ListUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerApplicationTests {

	@InjectMocks
	private CreateCustomerService service;

	@Mock
	private CreateCustomer createCustomer;



	@Captor
	private ArgumentCaptor<Customer> customerCaptor;

	@Mock
	private CreateCustomerValidator validator;



	@Test
	public void testCreateCustonmer () {
		Date currentDate = new Date();
		CreateCustomerCommand createCustomerCommand = CreateCustomerCommand.builder()
				.items(Arrays.asList(
						Customer.builder()
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
								.Passport(null)
								.passportIssueDate(currentDate)
								.passportIssuePlace(null)
								.passportExpiredDate(currentDate)
								.Gender("1")
								.build()
						))
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
				.Passport(null)
				.passportIssueDate(currentDate)
				.passportIssuePlace(null)
				.passportExpiredDate(currentDate)
				.Gender("1")
				.build();

		Mockito.doNothing().when(validator).validatorCustomer(createCustomerCommand.getItems().get(0));
		Mockito.when(createCustomer.save(createCustomerCommand.getItems().get(0))).thenReturn(item);

		List<Customer> customers = service.create(createCustomerCommand);
		Mockito.verify(createCustomer).save(customerCaptor.capture());
		Customer capturedValue = customerCaptor.getValue();

		for (Customer customer : customers) {
			Assertions.assertEquals(1,capturedValue.getCustomerId());
			Assertions.assertEquals(1,capturedValue.getId());
			Assertions.assertEquals("Alex",capturedValue.getCustomerName());
			Assertions.assertEquals("09039039289",capturedValue.getPhoneNumber());
			Assertions.assertEquals("alex@cuibap.timo.vn",capturedValue.getEmailAddress());
			Assertions.assertEquals(currentDate,capturedValue.getBDay());
			Assertions.assertEquals("Nha Trang",capturedValue.getPlaceOfBirth());
			Assertions.assertEquals("2378782389",capturedValue.getLegalId());
			Assertions.assertEquals("CCCD",capturedValue.getDocType());
			Assertions.assertEquals(currentDate,capturedValue.getDocIssueDate());
			Assertions.assertEquals(currentDate,capturedValue.getDocExpiredDate());
			Assertions.assertEquals(null,capturedValue.getPassport());
			Assertions.assertEquals(currentDate,capturedValue.getPassportIssueDate());
			Assertions.assertEquals(null,capturedValue.getPassportIssuePlace());
			Assertions.assertEquals(currentDate,capturedValue.getPassportExpiredDate());
			Assertions.assertEquals("1",capturedValue.getGender());
		}
	}


}
