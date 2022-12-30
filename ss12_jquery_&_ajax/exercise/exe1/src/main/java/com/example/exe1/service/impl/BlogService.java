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
    public boolean edit(Blog blog) {
        for (int i = 0; i < findAll().size(); i++) {
            if(blog.getTitle().equals(findAll().get(i).getTitle())){
                return false;
            }
        }
        iBlogRepository.save(blog);
        return true;
    }

    @Override
    public boolean add(Blog blog) {
        for (int i = 0; i < findAll().size(); i++) {
            if(blog.getTitle().equals(findAll().get(i).getTitle())){
                return false;
            }
        }
        iBlogRepository.save(blog);
        return true;
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

    @Override
    public List<Blog> findBlogByTitle(String title) {
        return iBlogRepository.findBlogByTitle(title);
    }

}
