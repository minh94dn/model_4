package com.service.impl;

import com.model.customer.Customer;
import com.repository.ICustomerRepository;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Override
//    public List<Customer> display() {
//        return iCustomerRepository.display();
//    }

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
}
