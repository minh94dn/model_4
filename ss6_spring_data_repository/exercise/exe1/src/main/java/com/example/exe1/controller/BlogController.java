package com.example.exe1.controller;

import com.example.exe1.model.Blog;
import com.example.exe1.service.IBlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String showListBlog(Model model) {
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/list";
    }

    @GetMapping("/add")
    public String showListAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/add";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
       boolean check = iBlogService.add(blog);
        String mess = "Thêm mới thành công";
        if(!check){
            mess = "Title này đã tồn tại";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id, Model model) {
        iBlogService.deleteById(id);
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        model.addAttribute("mess", "Xóa thành công");
        return "/blog/list";
    }

    @GetMapping("/edit/{id}")
        public String showFormEdit(@PathVariable("id") int id, Model model){
        Optional<Blog> blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        boolean check = iBlogService.edit(blog);
        String mess = "Chỉnh sửa thành công";
        if(!check){
            mess = "Title này đã tồn tại";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/blog";
    }
}
