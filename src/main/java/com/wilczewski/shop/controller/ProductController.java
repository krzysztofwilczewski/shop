package com.wilczewski.shop.controller;

import com.wilczewski.shop.model.Product;
import com.wilczewski.shop.repository.ProductRepository;
import com.wilczewski.shop.service.ProductService;
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

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/produkt/{productName}")
    public String getProduct(@PathVariable String productName, Model model )
    {
        Product product = productService.findByProductName(productName);

        model.addAttribute("product", product);


        return "product";

    }


    @GetMapping("/addproduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/save")
    public String addProduct(@RequestParam("file") MultipartFile file, Product product) throws IllegalStateException, IOException {

        String baseDir = "C:\\Users\\tworn\\IdeaProjects\\shop\\src\\main\\resources\\static\\images\\";
        file.transferTo(new File(baseDir + file.getOriginalFilename()));
        product.setImageUrl("/images/" + file.getOriginalFilename());

        productService.save(product);

        return "redirect:/";
    }
}
