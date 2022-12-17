package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class Caculator {
    @GetMapping("")
    public String showCalculator() {
        return "/calculator";
    }

    @PostMapping("/result")
    public String result(Model model, @RequestParam("number1") Double number1, @RequestParam("calculation") char calculation, @RequestParam("number2") Double number2) {
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        double result;
        String mess = null;
        switch (calculation){
            case '+':
                result = number1 + number2;
                model.addAttribute("result", "Result is: " + result);
                break;
            case '-' :
                result = number1 - number2;
                model.addAttribute("result", "Result is: " + result);
                break;
            case '*' :
                result = number1 * number2;
                model.addAttribute("result", "Result is: " + result);
                break;
            case '/' :
                if(number2==0) {
                    mess = "Không được phép chia cho 0";
                    model.addAttribute("mess", mess);
                }else {
                    result = number1 / number2;
                    model.addAttribute("result", "Result is: " + result);
                    break;
                }
            default:
                throw new RuntimeException("Không có phép tình này.");
        }
        model.addAttribute("calculation", calculation);

        return "/calculator";
    }
}
