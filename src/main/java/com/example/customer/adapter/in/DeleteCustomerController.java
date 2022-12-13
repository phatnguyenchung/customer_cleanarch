package com.example.customer.adapter.in;

import com.example.customer.application.port.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer", produces = APPLICATION_JSON_VALUE)
public class DeleteCustomerController {

    //@Autowired
    private final DeleteCustomerUseCase deleteCustomerUseCase;

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long customerId) {
        return new ResponseEntity<Object>(deleteCustomerUseCase.delete(customerId), HttpStatus.OK);
    }
}
