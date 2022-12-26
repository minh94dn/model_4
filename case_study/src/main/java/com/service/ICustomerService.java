package com.service;

import com.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
