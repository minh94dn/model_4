package com.controller;

import com.repository.DictionaryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/word")
public class WordTestController {
    private DictionaryRepository dictionaryRepository = new DictionaryRepository();
    @RequestMapping("")
    public String showFormDictionary() {
        return "/form";
    }

    @RequestMapping("/result")
    public String search(Model model, @RequestParam("english") String english) {
        model.addAttribute("english", english);
        model.addAttribute("result", dictionaryRepository.wordTest(english));
        return "/form";
    }
}
