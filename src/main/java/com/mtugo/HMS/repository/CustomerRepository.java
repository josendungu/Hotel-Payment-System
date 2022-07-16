package com.mtugo.HMS.repository;

import com.mtugo.HMS.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
