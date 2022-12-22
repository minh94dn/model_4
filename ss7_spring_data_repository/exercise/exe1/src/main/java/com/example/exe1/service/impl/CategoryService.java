package com.example.exe1.service.impl;

import com.example.exe1.model.Category;
import com.example.exe1.repository.ICategoryRepository;
import com.example.exe1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
