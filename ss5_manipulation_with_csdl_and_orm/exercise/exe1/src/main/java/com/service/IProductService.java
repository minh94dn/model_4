package com.service;

import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();

    void delete(int id);

    Product findId(int id);

    void update(Product product);

   void add(Product product);

    List<Product> search(String name);

}
