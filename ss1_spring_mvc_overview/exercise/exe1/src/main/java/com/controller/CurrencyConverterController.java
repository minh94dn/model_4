package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/converter")
public class CurrencyConverterController {
    @RequestMapping("")
    public String showConverterFrom() {
        return "/converter";
    }

    @RequestMapping("/result")
    public String converter(Model model, @RequestParam("usd") Double usd) {
        model.addAttribute("usd", usd);
        model.addAttribute("result", usd * 23000 + " VND");
        return "/converter";
    }
}
