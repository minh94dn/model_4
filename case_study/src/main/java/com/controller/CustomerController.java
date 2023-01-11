package com.controller;

import com.common.HandleException;
import com.dto.CustomerDto;
import com.model.customer.Customer;
import com.model.customer.CustomerType;
import com.service.customer.ICustomerService;
import com.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("")
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
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/add";
    }

    @PostMapping("/create")
    public String create(@Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "customer/add";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        boolean check = iCustomerService.add(customer);
        String mess = "Thêm mới thành công.";
        if (!check) {
            mess = "Thêm mới không thành công (ID Card hoặc Phone Number hoặc Email đã tồn tại)";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
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
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        Optional<Customer> customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        boolean check = iCustomerService.edit(customer);
        String mess = "Chỉnh sửa thành công.";
        if (!check) {
            mess = "Chỉnh sửa không thành công(ID Card hoặc Phone Number hoặc Email đã tồn tại)";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/customer";
    }
}
