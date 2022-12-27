package com.example.exe1.service.impl;

import com.example.exe1.exception.EmptyException;
import com.example.exe1.exception.NotFoundCodeException;
import com.example.exe1.model.Book;
import com.example.exe1.model.BookRental;
import com.example.exe1.repository.IBookRentalRepository;
import com.example.exe1.repository.IBookRepository;
import com.example.exe1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Autowired
    private IBookRentalRepository iBookRentalRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return iBookRepository.findById(id);
    }

    @Override
    public int rentBook(int id) throws EmptyException {
        Book book = findById(id).get();
        if (book.getQuantity() <= 0) {
            throw new EmptyException();
        }
        book.setQuantity(book.getQuantity() - 1);
        iBookRepository.save(book);
        int code = (int) Math.floor((Math.random() * 89999) + 10000);
        BookRental bookRental = new BookRental();
        bookRental.setBookId(book.getId());
        bookRental.setCode(code);
        iBookRentalRepository.save(bookRental);
        return code;
    }

    @Override
    public void giveBook(int code) throws NotFoundCodeException {
        BookRental bookRental = iBookRentalRepository.findByCode(code);
        if (bookRental != null) {
            Book book = iBookRepository.findById(bookRental.getBookId()).get();
            book.setQuantity(book.getQuantity() + 1);
            iBookRepository.save(book);
            iBookRentalRepository.deleteById(code);
        } else {
            throw new NotFoundCodeException();
        }
    }
}

