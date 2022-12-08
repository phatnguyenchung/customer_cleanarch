package com.example.customer.adapter.in;

import com.example.customer.application.port.in.UpdateCustomerComand;
import com.example.customer.application.port.in.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer", produces = APPLICATION_JSON_VALUE)
public class UpdateCustomerController {

    @Autowired
    private final UpdateCustomerUseCase updateCustomerUseCase;

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody UpdateCustomerComand customerCommand) {
        return new ResponseEntity<Object>(updateCustomerUseCase.update(customerCommand), HttpStatus.OK);
    }
}
