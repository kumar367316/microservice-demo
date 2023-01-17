package com.flipkart.oderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipkart.oderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
