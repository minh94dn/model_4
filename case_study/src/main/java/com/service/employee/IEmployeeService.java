package com.service.employee;

import com.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
