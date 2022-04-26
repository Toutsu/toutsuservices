package com.toutsu.customer.service;

import com.toutsu.customer.CustomerRegistrationRequest;
import com.toutsu.customer.FraudCheckResponse;
import com.toutsu.customer.entity.Customer;
import com.toutsu.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email()).build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
