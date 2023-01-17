package com.flipkart.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.paymentservice.entity.Payment;
import com.flipkart.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payment-management")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payment/{paymentStatus}/{amount}")
	public Payment getProducts(@PathVariable String paymentStatus,@PathVariable double amount) {
		return paymentService.savePayment(paymentStatus,amount);
	}
}
