package com.example.exe1.controller;

import com.example.exe1.model.Blog;
import com.example.exe1.model.Category;
import com.example.exe1.service.IBlogService;
import com.example.exe1.service.ICategoryService;
import com.example.exe1.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showListBlog(Model model) {
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/list";
    }

    @GetMapping("/add")
    public String showListAdd(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "/blog/add";
    }

    @PostMapping("/save")
    public String save(Model model, Blog blog) {
        iBlogService.save(blog);
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        model.addAttribute("mess", "Thêm mới thành công");
        return "/blog/list";
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
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        Optional<Blog> blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String update(Model model, @ModelAttribute("blog") Blog blog){
        iBlogService.save(blog);
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        model.addAttribute("mess", "Chỉnh sửa thành công");
        return "/blog/list";
    }

    @GetMapping("/search")
    private String search(@RequestParam(name = "search", defaultValue = "") String title, Model model, Pageable pageable) {
        Page<Blog> blogList = iBlogService.findByTitleContaining(title, pageable);
        model.addAttribute("blogList", blogList);
        model.addAttribute("search", title);
        return "/blog/list";
    }
}

