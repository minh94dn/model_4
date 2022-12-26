package com.controller;

import com.model.customer.Customer;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @RequestMapping("")
    private String showListCustomer(Model model){
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }
}
