package com.wilczewski.shop.controller;

import com.wilczewski.shop.model.Product;
import com.wilczewski.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    private ProductService productService;

    @Autowired
    public IndexController(ProductService productService){
        this.productService = productService;
    }



    @GetMapping("/")
    public String  index(Model model){

        model.addAttribute("products", productService.getAllProduct());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, String error){
        if (error != null)
            model.addAttribute("error","login or password invalid");
        return "login";
}
}
