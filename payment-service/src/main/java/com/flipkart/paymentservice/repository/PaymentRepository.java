package com.flipkart.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipkart.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
