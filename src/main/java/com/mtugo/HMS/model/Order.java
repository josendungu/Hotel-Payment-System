package com.mtugo.HMS.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(
        name = "Orders"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @SequenceGenerator(
            sequenceName = "order_sequence",
            allocationSize = 1,
            name = "order_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long orderId;

    @Column(
            nullable = false
    )
    private LocalDate date;

    @OneToOne
    @JoinColumn(
            name = "payment_id",
            referencedColumnName = "paymentId"
    )
    private Payment payment;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "customerId",
            nullable = false
    )
    private Customer customer;

    @Column(nullable = false)
    private int totalAmount;



}
