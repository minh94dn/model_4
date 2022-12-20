package com.controller;

import com.model.Product;
import com.service.IProductService;
import com.service.impl.ProductService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private IProductService iProductService = new ProductService();

    @GetMapping("")
    public String showListProduct(Model model) {
        List<Product> productList = iProductService.showAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        Product product = iProductService.findId(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(Model model, Product product) {
        iProductService.update(product);
        List<Product> productList = iProductService.showAll();
        model.addAttribute("productList", productList);
        model.addAttribute("message", "Chỉnh sửa thành công !");
        return "/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("product", new Product());
        return "/add";
    }

    @PostMapping("/save")
    public String add(Product product, Model model) {
        iProductService.add(product);
        List<Product> productList = iProductService.showAll();
        model.addAttribute("productList", productList);
        model.addAttribute("message", "Thêm mới thành công !");
        return "/list";
    }

    @GetMapping("/search")
    public String search(Model model, String name) {
        List<Product> productList = iProductService.search(name);
        model.addAttribute("productList", productList);
        return "/list";
    }

    @PostMapping("/delete")
    public String remove(Model model, @RequestParam("deleteId") int id, Product product){
        iProductService.delete(id);
        List<Product> productList = iProductService.showAll();
        model.addAttribute("productList", productList);
        model.addAttribute("massage", "Xóa thành công !");
        return "/list";
    }
}
