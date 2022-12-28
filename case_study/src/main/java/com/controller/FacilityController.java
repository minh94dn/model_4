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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Page<Facility> facilityList = iFacilityService.findByNameAndFacilityType(name,facilityType,pageable);
        model.addAttribute("facilityList", facilityList);
        return "facility/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes){
        iFacilityService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công.");
        return "redirect:/facility";
    }
}
