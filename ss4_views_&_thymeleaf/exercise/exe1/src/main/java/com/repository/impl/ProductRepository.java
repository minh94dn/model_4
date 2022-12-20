package com.repository.impl;

import com.model.Product;
import com.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Bàn", 100, "Tốt", "abc"));
        productList.add(new Product(2, "Ghế", 50, "Đẹp", "xyz"));
        productList.add(new Product(3, "Tủ", 200, "Bền", "abc"));
    }

    @Override
    public List<Product> showAll() {
        return productList;
    }


    @Override
    public void update(Product product) {
        productList.set(findIndex(product.getId()), product);
    }

    @Override
    public Product findId(int id) {
        for (Product p : productList) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> add(Product product) {
        productList.add(product);
        return productList;
    }

    public int findIndex(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void delete(int id) {
        for (Product p : productList) {
            if (id == p.getId()) {
                productList.remove(p);
                break;
            }
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (Product p : productList) {
            if(name.equals(p.getName())){
                productList1.add(p);
            }
        }
        return productList1;
    }
}
