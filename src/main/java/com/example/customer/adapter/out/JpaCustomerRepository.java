package com.example.customer.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerJpaEntity, Long> {

    Optional<CustomerJpaEntity> findByCustomerIdAndId(Long id, Long customerId);

    Optional<CustomerJpaEntity> findByCustomerId(Long customerId);

    Boolean existsByIdOrLegalIdOrPassportOrPhoneNumber(Long id, String legalId, String passport, String phoneNumber);
}
