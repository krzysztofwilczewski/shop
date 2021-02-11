package com.wilczewski.shop.controller;

import com.wilczewski.shop.model.Product;
import com.wilczewski.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private ProductRepository productRepository;

    @Autowired
    public IndexController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }



    @GetMapping("/")
    public String  index(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "addproduct";
    }
}
