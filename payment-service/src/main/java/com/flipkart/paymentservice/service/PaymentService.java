package com.flipkart.paymentservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.paymentservice.entity.Payment;
import com.flipkart.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public Payment savePayment(String paymentStatus,double amount) {
		Payment payment = new Payment();
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentStatus);
		payment.setAmount(amount);
        return paymentRepository.save(payment);
		
	}
}
