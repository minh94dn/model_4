package com.repository;

import com.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showAll();

    void update(Product product);

    Product findId(int id);

    List<Product> add(Product product);

    boolean delete(int id);

    List<Product> search(String name);
}
