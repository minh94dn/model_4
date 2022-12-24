package com.example.exe1.controller;

import com.example.exe1.dto.UserDto;
import com.example.exe1.model.User;
import com.example.exe1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showAdd(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/create")
    public String add(@Validated UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.add(user);
        model.addAttribute("mess", "Đăng ký thành công");
        return "/user/result";
    }
}
