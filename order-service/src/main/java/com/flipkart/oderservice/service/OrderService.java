package com.flipkart.oderservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flipkart.oderservice.entity.Order;
import com.flipkart.oderservice.exception.QuantityException;
import com.flipkart.oderservice.repository.OrderRepository;

@Service
public class OrderService {

	public static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderRepository orderRepository;

	public Order saveOrder(Order order) {

		RestTemplate restTemplate = new RestTemplate();
		Order save = new Order();
		// before order must be check product is available or not
		String productName = order.getName();
		int orderQty = order.getQty();
		double amount = order.getPrice();

		int totalQuantity = restTemplate.getForObject(
				"http://localhost:8183/product-management/getproductsqty/" + productName + "/" + orderQty,
				Integer.class);
		if (totalQuantity > 0 && order.getQty() <= totalQuantity) {
			String paymentMessage = restTemplate.getForObject(
					"http://localhost:8182/payment-management/payment/" + "intiated" + "/" + amount, String.class);
			logger.info("payment status: " + paymentMessage);
			save = orderRepository.save(order);
		} else {
			throw new QuantityException("quantity insufficent for " + productName);
		}
		return save;
	}

}
