package com.example.exe1.service.impl;

import com.example.exe1.model.BookRental;
import com.example.exe1.repository.IBookRentalRepository;
import com.example.exe1.service.IBookRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentalService implements IBookRentalService {
    @Autowired
    private IBookRentalRepository iBookRentalRepository;

    @Override
    public List<BookRental> findAll() {
        return iBookRentalRepository.findAll();
    }

    @Override
    public BookRental findByCode(int code) {
        return iBookRentalRepository.findByCode(code);
    }
}
