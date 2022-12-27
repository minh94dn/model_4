package com.controller;

import com.model.customer.Customer;
import com.model.customer.CustomerType;
import com.service.ICustomerService;
import com.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @RequestMapping("")
    public String showListCustomer(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }

    @PostMapping("/create")
    public String create(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.add(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        iCustomerService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        Optional<Customer> customer = iCustomerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes){
        iCustomerService.edit(customer);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/customer";
    }
}
