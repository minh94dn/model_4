package com.example.exe1.service.impl;

import com.example.exe1.model.Blog;
import com.example.exe1.repository.IBlogRepository;
import com.example.exe1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByTitleContaining(String title, Pageable pageable) {
        return iBlogRepository.findByTitleContaining(title, pageable);
    }

}
