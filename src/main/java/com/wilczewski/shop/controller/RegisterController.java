package com.wilczewski.shop.controller;


import com.wilczewski.shop.model.User;
import com.wilczewski.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration(Model model){
        model.addAttribute("userCreate",new User());
        return "register";
    }
  //  @PostMapping("/register")
  //  public String registration(@ModelAttribute User userCreate){
  //      userService.saveUser(userCreate);

  //      return "redirect:/";
  //  }

}
