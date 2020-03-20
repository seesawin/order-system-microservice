package com.tianyalan.microservice.order.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tianyalan.microservice.order.gateway.domain.Customer;

@Service
public class CustomerHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackCustomer")
    public Customer getCustomer(Long customerId) {
        Customer forObject = null;
        try {
            forObject = restTemplate.getForObject("http://localhost:8082/" + customerId, Customer.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerHystrixService customer = " + forObject.toString());
        return forObject;
    }

    public Customer fallbackCustomer(Long customerId) {
        Customer customer = new Customer();
        customer.setDescription(customerId + ": Customer service failed!");
        return customer;
    }
}



