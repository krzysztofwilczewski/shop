package com.wilczewski.shop.controller;

import com.wilczewski.shop.model.Product;
import com.wilczewski.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {

    private ProductRepository productRepository;



    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @GetMapping("/produkt/{productName}")
    public String getProduct(@PathVariable String productName, Model model )
    {

        Product product = productRepository.findByProductName(productName);

        model.addAttribute("product", product);


        return "product";

    }




    @PostMapping("/save")
    public String processUpload(@RequestParam("file") MultipartFile file, Product product) throws IllegalStateException, IOException {

        String baseDir = "C:\\uploads\\";
        file.transferTo(new File(baseDir + file.getOriginalFilename()));
        product.setImageUrl(baseDir + file.getOriginalFilename());

        productRepository.save(product);

        return "redirect:/";
    }
}
