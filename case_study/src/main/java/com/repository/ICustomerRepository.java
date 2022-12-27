package com.repository;

import com.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = "select * from `customer` c join `customer_type` ct on c.customer_type_id=ct.id",nativeQuery = true)
//    List<Customer> display();
}
