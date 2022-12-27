package com.example.exe1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookRental {
    @Id
    private int code;
    private int bookId;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
