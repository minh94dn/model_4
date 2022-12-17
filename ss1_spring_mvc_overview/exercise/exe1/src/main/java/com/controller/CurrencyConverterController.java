package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/converter")
public class CurrencyConverterController {
    @GetMapping("")
    public String showConverterFrom() {
        return "/converter";
    }

    @PostMapping("/result")
    public String converter(Model model, @RequestParam("usd") Double usd) {
        model.addAttribute("usd", usd);
        model.addAttribute("result", usd * 23000 + " VND");
        return "/converter";
    }
}
