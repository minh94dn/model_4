package com.service;

import com.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

//    List<Customer> display();

    void add(Customer customer);

    void edit(Customer customer);

    Optional<Customer> findById(int id);

    void deleteById(int id);
}
