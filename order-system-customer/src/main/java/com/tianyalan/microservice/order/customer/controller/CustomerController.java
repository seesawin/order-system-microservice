package com.tianyalan.microservice.order.customer.controller;

import com.tianyalan.microservice.order.customer.domain.Customer;
import com.tianyalan.microservice.order.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long customerId) {
//		log.info("CustomerController customerId = {}", customerId);
		System.out.println("CustomerController customerId = " + customerId);
		Customer customer = customerService.getCustomerById(customerId);
    	return customer;
    }
}






