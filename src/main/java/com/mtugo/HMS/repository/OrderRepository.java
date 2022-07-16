package com.mtugo.HMS.repository;

import com.mtugo.HMS.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
