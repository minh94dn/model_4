package com.service.impl;

import com.model.Product;
import com.repository.IProductRepository;
import com.repository.impl.ProductRepository;
import com.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> showAll() {
        return iProductRepository.showAll();
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public Product findId(int id) {
        return iProductRepository.findId(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public List<Product> add(Product product) {
        return iProductRepository.add(product);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }
}
