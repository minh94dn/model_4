package com.controller;

import com.dto.IContractDto;
import com.model.contract.Contract;
import com.model.contract.ContractDetail;
import com.service.contract.IAttachFacilityService;
import com.service.contract.IContractDetailService;
import com.service.contract.IContractService;
import com.service.customer.ICustomerService;
import com.service.employee.IEmployeeService;
import com.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService icontractService;

    @Autowired
    private ICustomerService icustomerService;

    @Autowired
    private IEmployeeService iemployeeService;

    @Autowired
    private IFacilityService ifacilityService;

    @Autowired
    private IAttachFacilityService iattachFacilityService;

    @Autowired
    private IContractDetailService icontractDetailService;

    @GetMapping("")
    public String showListContract(@PageableDefault(value = 5)Pageable pageable, Model model){
        Page<IContractDto> contractList = icontractService.listContract(pageable);
        model.addAttribute("contractList", contractList);
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contract", new Contract());
        model.addAttribute("attachFacilityList", iattachFacilityService.findAll());
        model.addAttribute("customerList", icustomerService.findAll());
        model.addAttribute("facilityList", ifacilityService.findAll());
        model.addAttribute("employeeList", iemployeeService.findAll());

        return "contract/list";
    }
    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes){
       icontractDetailService.add(contractDetail);
       redirectAttributes.addFlashAttribute("mess", "Thêm mới dịch vụ thành công.");
       return "redirect:/contract";
    }
 
}
