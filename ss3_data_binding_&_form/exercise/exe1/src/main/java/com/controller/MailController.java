package com.controller;

import com.model.Mail;
import com.service.IMailService;
import com.service.impl.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
    private IMailService iMailService = new MailService();

    @GetMapping("")
    public String showListEmail(Model model) {
        List<Mail> mailList = iMailService.showAll();
        model.addAttribute("mailList", mailList);
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        Mail mail = iMailService.findById(id);
        List<String> languageList = iMailService.getLanguageList();
        List<Integer> pageSizeList = iMailService.getPageSizeList();
        model.addAttribute("mail", mail);
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("mail") Mail mail, Model model, RedirectAttributes redirectAttributes) {
        iMailService.update(mail);
        return "redirect:/mail";
    }

}
