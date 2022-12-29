package com.example.exe1.service;

import com.example.exe1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    boolean edit(Blog blog);

    boolean add(Blog blog);

    Optional<Blog> findById(int id);

    void deleteById(int id);

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    List<Blog> findBlogByCategory(int id);

}
