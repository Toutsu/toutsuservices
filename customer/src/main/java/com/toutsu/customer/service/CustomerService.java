package com.toutsu.customer.service;

import com.toutsu.customer.CustomerRegistrationRequest;
import com.toutsu.customer.entity.Customer;
import com.toutsu.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email()).build();
        customerRepository.save(customer);
    }
}
