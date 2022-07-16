package com.mtugo.HMS.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Payments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Payment {

    @Id
    @SequenceGenerator(
            sequenceName = "payment_sequence",
            allocationSize = 1,
            name = "payment_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private Long paymentId;

    @Column(nullable = false)
    private int amountPaid;

    @OneToOne
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "orderId",
            nullable = false
    )
    private Order order;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "customerId",
            nullable = false
    )
    private Customer customer;


}
