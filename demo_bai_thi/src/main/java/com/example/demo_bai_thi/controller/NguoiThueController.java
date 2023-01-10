package com.example.demo_bai_thi.controller;

import com.example.demo_bai_thi.dto.NguoiThueDto;
import com.example.demo_bai_thi.model.NguoiThue;
import com.example.demo_bai_thi.service.IHinhThucThanhToanService;
import com.example.demo_bai_thi.service.INguoiThueService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/nguoiThue")
public class NguoiThueController {
    @Autowired
    private INguoiThueService iNguoiThueService;

    @Autowired
    private IHinhThucThanhToanService iHinhThucThanhToanService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String phoneNumber,
                           @PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<NguoiThue> nguoiThueList = iNguoiThueService.findByNameAndPhoneNumber(name, phoneNumber, pageable);
        model.addAttribute("nguoiThueList", nguoiThueList);
        return "nguoiThue/list";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam("deleteId") String id, RedirectAttributes redirectAttributes) {
        String[] stringId = id.split(",");
        for (int i = 0; i < stringId.length; i++) {
            iNguoiThueService.delete(Integer.parseInt(stringId[i]));
        }
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công.");
        return "redirect:/nguoiThue";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("hinhThucThanhToanList", iHinhThucThanhToanService.findAll());
        model.addAttribute("nguoiThueDto", new NguoiThueDto());
        return "nguoiThue/add";
    }

    @PostMapping("create")
    public String create(@Validated NguoiThueDto nguoiThueDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hinhThucThanhToanList", iHinhThucThanhToanService.findAll());
            return "nguoiThue/add";
        }
        NguoiThue nguoiThue = new NguoiThue();
        BeanUtils.copyProperties(nguoiThueDto, nguoiThue);
        iNguoiThueService.add(nguoiThue);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/nguoiThue";
    }
}
