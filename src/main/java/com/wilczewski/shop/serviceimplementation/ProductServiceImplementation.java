package com.wilczewski.shop.serviceimplementation;

import com.wilczewski.shop.model.Product;
import com.wilczewski.shop.repository.ProductRepository;
import com.wilczewski.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }


    public List<Product> getAllProduct(){
        return  productRepository.findAll();
    }

    public void save (Product product){
        productRepository.save(product);
    }


    public Product findByProductName(String productName){
        return productRepository.findByProductName(productName);
    }

    public Product getProductById(Long productId){
        return productRepository.getOne(productId);
    }



}
