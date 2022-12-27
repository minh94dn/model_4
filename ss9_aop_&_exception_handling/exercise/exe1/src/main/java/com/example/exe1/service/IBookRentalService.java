package com.example.exe1.service;

import com.example.exe1.model.BookRental;

import java.util.List;

public interface IBookRentalService {
    List<BookRental> findAll();

    BookRental findByCode(int code);
}
