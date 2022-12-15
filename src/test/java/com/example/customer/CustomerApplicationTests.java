package com.example.customer;

import com.example.customer.adapter.out.JpaCustomerRepository;
import com.example.customer.application.port.in.CreateCustomerCommand;
import com.example.customer.application.port.out.CreateCustomer;
import com.example.customer.application.service.customer.CreateCustomerService;
import com.example.customer.application.validator.CreateCustomerValidator;
import com.example.customer.domain.Customer;
import org.apache.commons.lang3.ArrayUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

		Assertions.assertThat(customers.size() == 1);

		for (Customer customer : customers) {
			assertAll(
					() -> Assertions.assertThat(customer.getCustomerId()).isEqualTo(1L),
					() -> Assertions.assertThat(customer.getId()).isEqualTo(1L),
					() -> Assertions.assertThat(customer.getCustomerName()).isEqualTo("Alex"),
					() -> Assertions.assertThat(customer.getPhoneNumber()).isEqualTo("09039039289"),
					() -> Assertions.assertThat(customer.getEmailAddress()).isEqualTo("alex@cuibap.timo.vn"),
					() -> Assertions.assertThat(customer.getBDay()).isEqualTo(currentDate),
					() -> Assertions.assertThat(customer.getPlaceOfBirth()).isEqualTo("Nha Trang"),
					() -> Assertions.assertThat(customer.getLegalId()).isEqualTo("2378782389"),
					() -> Assertions.assertThat(customer.getDocType()).isEqualTo("CCCD"),
					() -> Assertions.assertThat(customer.getDocIssuePlace()).isEqualTo("Ho Chi Minh"),
					() -> Assertions.assertThat(customer.getDocIssueDate()).isEqualTo(currentDate),
					() -> Assertions.assertThat(customer.getDocExpiredDate()).isEqualTo(currentDate),
					() -> Assertions.assertThat(customer.getPassport()).isEqualTo(null),
					() -> Assertions.assertThat(customer.getPassportIssueDate()).isEqualTo(currentDate),
					() -> Assertions.assertThat(customer.getPassportIssuePlace()).isEqualTo(null),
					() -> Assertions.assertThat(customer.getPassportExpiredDate()).isEqualTo(currentDate),
					() -> Assertions.assertThat(customer.getGender()).isEqualTo("1")
			);
		}
	}
}
