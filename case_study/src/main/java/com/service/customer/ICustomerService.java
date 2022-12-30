package com.service.customer;

import com.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    boolean add(Customer customer);

    boolean edit(Customer customer);

    Optional<Customer> findById(int id);

    void deleteById(int id);

    Page<Customer> findByAll(String name, String email, String customerType, Pageable pageable);
}
