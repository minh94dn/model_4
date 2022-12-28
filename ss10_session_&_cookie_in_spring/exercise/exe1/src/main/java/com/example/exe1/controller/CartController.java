package com.example.exe1.controller;

import com.example.exe1.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
    public String showCart(@SessionAttribute("cart") CartDto cart, Model model) {
        model.addAttribute("cart",cart);
        return "cart/list";
    }

}
