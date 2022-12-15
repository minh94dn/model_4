package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/word")
public class WordTestController {
    @RequestMapping("")
    public String showFormDictionary() {
        return "/form";
    }

    @RequestMapping("/result")
    public String search(Model model, @RequestParam("english") String english) {
        model.addAttribute("english", english);
        String result;
        switch (english) {
            case "apple":
                result = "Quả táo";
                model.addAttribute("result", result);
                break;
            case "banana":
                result = "Quả chuối";
                model.addAttribute("result", result);
                break;
            case "orange":
                result = "Quả cam";
                model.addAttribute("result", result);
                break;
            case "mango":
                result = "Quả xoài";
                model.addAttribute("result", result);
                break;
            case "fruit":
                result = "Trái cây";
                model.addAttribute("result", result);
                break;
            default:
                result = "Không tìm thấy từ này trong từ điển.";
        }
        return "/form";
    }
}
