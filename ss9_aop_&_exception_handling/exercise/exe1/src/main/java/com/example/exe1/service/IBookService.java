package com.example.exe1.service;

import com.example.exe1.exception.EmptyException;
import com.example.exe1.exception.NotFoundCodeException;
import com.example.exe1.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Optional<Book> findById(int id);

    int rentBook(int id) throws EmptyException;

    void giveBook(int code) throws NotFoundCodeException;
}
