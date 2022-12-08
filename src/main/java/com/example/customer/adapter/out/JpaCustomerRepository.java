package com.example.customer.adapter.out;

import com.example.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerJpaEntity, Long> {

    Optional<CustomerJpaEntity> findByCustomerIdAndId(Long id, Long customerId);

    Boolean existsByIdOrLegalIdOrPassportOrPhoneNumber(Long id, String legalId, String passport, String phoneNumber);
}
