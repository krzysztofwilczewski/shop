package com.wilczewski.shop.service;

import com.wilczewski.shop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    void save(Product product);

    Product findByProductName(String productName);

    Product getProductById(Long productId);
}
