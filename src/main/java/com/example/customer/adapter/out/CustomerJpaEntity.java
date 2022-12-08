package com.example.customer.adapter.out;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Customer")
@Table(name = "tblCustomer")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CustomerJpaEntity implements Serializable {
    @Column(name = "Id")
    private Long id;

    @Id
    @Column(name = "CustomerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name="EmailAddress")
    private String emailAddress;

    @Column(name = "BDay")
    private Date bDay;

    @Column(name = "PlaceOfBirth")
    private String placeOfBirth;

    @Column(name = "LegalId")
    private String legalId;

    @Column(name = "DocType")
    private String docType;

    @Column(name = "DocIssueDate")
    private Date docIssueDate;

    @Column(name = "DocIssuePlace")
    private String docIssuePlace;

    @Column(name = "DocExpiredDate")
    private Date docExpiredDate;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Passport")
    private String passport;

    @Column(name = "PassportIssueDate")
    private Date passportIssueDate;

    @Column(name = "PassportIssuePlace")
    private String passportIssuePlace;

    @Column(name = "PassportExpiredDate")
    private Date passportExpiredDate;
}
