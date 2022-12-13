package com.example.customer.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerJpaEntity, Long> {

    Optional<CustomerJpaEntity> findByCustomerIdAndId(Long id, Long customerId);

    Optional<CustomerJpaEntity> findByCustomerId(Long customerId);

    Optional<CustomerJpaEntity> findByCustomerName(String customerName);

    Boolean existsByIdOrLegalIdOrPassportOrPhoneNumber(Long id, String legalId, String passport, String phoneNumber);

    Boolean existsByLegalId(String legalId);

    Boolean existsByPassport(String passport);

    Boolean existsByPhoneNumber(String phoneNumber);
}
