package com.wilczewski.shop.serviceimplementation;

import com.wilczewski.shop.model.Cart;
import com.wilczewski.shop.repository.CartRepository;
import com.wilczewski.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
public class CartServiceImplementation implements CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartServiceImplementation(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addCart(Cart cart){
        cartRepository.save(cart);
    }

}
