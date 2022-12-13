package com.example.customer.adapter.in;

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


    @GetMapping("/getCustomer")
    public ResponseEntity<Object> search(@RequestBody CustomerRequest customerRequest) {
        return new ResponseEntity<Object>(getCustomerUseCase.getCustomer(),HttpStatus.OK);
    }

    @GetMapping("/getcustomerbyid")
    public ResponseEntity<Object> searchById(@RequestParam long id) {
        return new ResponseEntity<Object>(getCustomerUseCase.getCustomerById(id),HttpStatus.OK);
    }

    @GetMapping("/getcustomerbyuserid")
    public ResponseEntity<Object> searchbyuserid(@RequestParam long customerId) {
        return new ResponseEntity<Object>(getCustomerUseCase.getCustomerByUserId(customerId),HttpStatus.OK);
    }

    @GetMapping("/getcustomerbyname")
    public ResponseEntity<Object> searchbycustomername(@RequestParam String customerName){
        return new ResponseEntity<Object>(getCustomerUseCase.getCustomerByName(customerName),HttpStatus.OK);
    }
}
