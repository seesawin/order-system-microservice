package com.tianyalan.microservice.order.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tianyalan.microservice.order.gateway.domain.Product;

@Service
public class ProductHystrixService {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackProduct") 
	public Product getProduct(String productName) {
		Product forObject = null;
		try {
			forObject = restTemplate.getForObject("http://localhost:8081/" + productName, Product.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		System.out.println("ProductHystrixService customer = " + forObject.toString());
		return forObject;
	}
	
	public Product fallbackProduct(String productName){ 
		Product product = new Product();
		product.setDescription(productName + ": Product service failed!");
		return product;
	}
	
}
