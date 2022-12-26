package com.example.exe1.service;

import com.example.exe1.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    boolean add(Blog blog);

    boolean edit(Blog blog);

    Optional<Blog> findById(int id);

    void deleteById(int id);

}
