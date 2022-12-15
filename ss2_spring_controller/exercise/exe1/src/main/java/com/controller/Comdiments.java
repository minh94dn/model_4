package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller

public class Comdiments {
@GetMapping("")
    public String showComdimentList() {
        return "/comdimentList";
    }

    @RequestMapping("/save")
    public String result(Model model, @RequestParam("choose") String[] choose) {
        model.addAttribute("choose", Arrays.toString(choose));
        return "/comdimentList";
    }
}
