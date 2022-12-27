package com.example.exe1.controller;

import com.example.exe1.exception.EmptyException;
import com.example.exe1.exception.NotFoundCodeException;
import com.example.exe1.model.Book;
import com.example.exe1.model.BookRental;
import com.example.exe1.service.IBookRentalService;
import com.example.exe1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookRentalService iBookRentalService;

    @GetMapping("")
    public String showListBook(Model model){
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        List<BookRental> bookRentalList = iBookRentalService.findAll();
        model.addAttribute("bookRentalList", bookRentalList);
        return "book/list";
    }

    @GetMapping("/rent/{id}")
    public String showDetail(@PathVariable int id, Model model){
        Book book = iBookService.findById(id).get();
        model.addAttribute("book", book);
        return "book/detail";
    }

    @PostMapping("/rent")
    public String rentBook(@RequestParam int id, RedirectAttributes redirectAttributes) throws EmptyException {
        int code = iBookService.rentBook(id);
        redirectAttributes.addFlashAttribute("mess", "Mượn sách thành công, mã sách mượn sách là: " + code);
        return "redirect:/book";
    }

    @PostMapping("/give")
    public String giveBook(@RequestParam int code, RedirectAttributes redirectAttributes) throws NotFoundCodeException {
        iBookService.giveBook(code);
        redirectAttributes.addFlashAttribute("mess","Mã số trả sách: " + code + "trả sách thành công");
        return "redirect:/book";
    }
}
