package com.controller;

import com.model.customer.Customer;
import com.model.customer.CustomerType;
import com.service.customer.ICustomerService;
import com.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String showListCustomer(@RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "") String email,
                                   @RequestParam(defaultValue = "") String customerType,
                                   @PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Customer> customerList = iCustomerService.findByAll(name, email, customerType, pageable);
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
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

    @PostMapping("/delete")
    public String remove(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes) {
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
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.edit(customer);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/customer";
    }
}
