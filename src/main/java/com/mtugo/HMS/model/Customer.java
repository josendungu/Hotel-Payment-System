package com.mtugo.HMS.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(
        name = "Customers"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @SequenceGenerator(
            sequenceName = "customer_sequence",
            allocationSize = 1,
            name = "customer_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long customerId;

    @Column(
            nullable = false,
            length = 50,
            columnDefinition = "TEXT"
    )
    private String customerFirstName;

    @Column(
            nullable = false,
            length = 50,
            columnDefinition = "TEXT"
    )
    private String customerLastName;

    @Column(
            nullable = false,
            length = 12,
            columnDefinition = "TEXT"
    )
    private String customerPhoneNumber;

}
