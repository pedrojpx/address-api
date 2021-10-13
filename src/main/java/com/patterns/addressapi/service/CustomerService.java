package com.patterns.addressapi.service;

import com.patterns.addressapi.model.Customer;

/**
 * This interface defines the Strategy pattern for Customer, this way we can have various implementations of the interface
 * for different possible services that deal with customers
 */
public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(Long id);

    void create(Customer c);

    void update(Long id, Customer c);

    void delete(Long id);
}
