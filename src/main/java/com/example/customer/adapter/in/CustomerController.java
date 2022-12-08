package com.example.customer.adapter.in;

import com.example.customer.application.port.in.CustomerCommand;
import com.example.customer.application.port.in.GetCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/customer")
public class CustomerController {

    private final GetCustomerUseCase getCustomerUseCase;


    public CustomerController(GetCustomerUseCase getCustomerUseCase) {
        this.getCustomerUseCase = getCustomerUseCase;
    }


    @GetMapping("/getcustomer")
    public ResponseEntity<Object> search(@RequestBody CustomerRequest customerRequest) {
        return new ResponseEntity<Object>(getCustomerUseCase.getCustomer(),HttpStatus.OK);
    }


}
