package com.example.exe1.service;

import com.example.exe1.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(int id);
}
