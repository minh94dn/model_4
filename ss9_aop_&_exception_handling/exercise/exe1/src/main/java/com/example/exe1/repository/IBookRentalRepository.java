package com.example.exe1.repository;

import com.example.exe1.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBookRentalRepository extends JpaRepository<BookRental, Integer> {
    @Query(value = "select * from book_rental where code = :code", nativeQuery = true)
    BookRental findByCode(int code);
}
