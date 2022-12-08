package com.example.customer.adapter.out;

import com.example.customer.application.port.out.GetCustomer;
import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.CustomerUserIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerAdapter implements GetCustomer {

    @Autowired
    private JpaCustomerRepository jpaCustomerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        try{
            List<CustomerJpaEntity> lst = jpaCustomerRepository.findAll();
            for(CustomerJpaEntity entity : lst) {
                System.out.println(entity.getCustomerId());
            }
            return jpaCustomerRepository.findAll().stream().map(CustomerMapper::mapToDomainEntity).collect(Collectors.toList());
        }catch(Exception e)
        {
            throw new RuntimeException(new CustomerNotFoundException());
        }
    }

    @Override
    public Customer getCustomerById(long id) {
        try {
            return jpaCustomerRepository
                    .findById(id)
                    .map(CustomerMapper::mapToDomainEntity)
                    .orElseThrow(CustomerNotFoundException::new);
        }
        catch (Exception e){
            throw new RuntimeException(new CustomerNotFoundException(id));
        }
    }

    @Override
    public Customer getByIdAndCustomerId(long id, long customerId) {
        return jpaCustomerRepository
                .findByCustomerIdAndId(id,customerId)
                .map(CustomerMapper::mapToDomainEntity)
                .orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public Customer getCustomerByCustomerId(long customerId) {
        try {
            return jpaCustomerRepository
                    .findByCustomerId(customerId)
                    .map(CustomerMapper::mapToDomainEntity)
                    .orElseThrow(CustomerNotFoundException::new);
        }
        catch (Exception e){
            throw new RuntimeException(new CustomerUserIdNotFoundException(customerId));
        }
    }

    @Override
    public boolean existsByIdOrLegalIdOrPassportOrPhoneNumber(Long id, String legalId, String passport, String phoneNumber) {
        return jpaCustomerRepository.existsByIdOrLegalIdOrPassportOrPhoneNumber(id,legalId,passport,phoneNumber);
    }


}
