package com.service.customer.impl;

import com.model.customer.Customer;
import com.repository.customer.ICustomerRepository;
import com.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByAll(String name, String email, String customerType, Pageable pageable) {
        return iCustomerRepository.findByAll(name,email,customerType, pageable );
    }


}