package com.example.customer.adapter.in;

import com.example.customer.application.port.in.CreateCustomerCommand;
import com.example.customer.application.port.in.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer", produces = APPLICATION_JSON_VALUE)
public class CreateCustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateCustomerCommand customerCommand) {
        return new ResponseEntity<Object>(createCustomerUseCase.create(customerCommand), HttpStatus.OK);
    }
}
