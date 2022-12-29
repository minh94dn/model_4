package com.controller;

import com.model.facility.Facility;
import com.service.facility.IFacilityService;
import com.service.facility.IFacilityTypeService;
import com.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String showListFacility(@RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "") String facilityType,
                                   @PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Facility> facilityList = iFacilityService.findByNameAndFacilityType(name, facilityType, pageable);
        model.addAttribute("facilityList", facilityList);
        return "facility/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes) {
        iFacilityService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công.");
        return "redirect:/facility";
    }

    @GetMapping("/add")
    public String showFromAdd(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "facility/add";
    }

    @PostMapping("create")
    public String create(Facility facility, RedirectAttributes redirectAttributes) {
        iFacilityService.add(facility);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công.");
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("facility", iFacilityService.findById(id));
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "facility/edit";
    }

    @PostMapping("update")
    public String update(Facility facility, RedirectAttributes redirectAttributes){
        iFacilityService.edit(facility);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công.");
        return "redirect:/facility";
    }
}
