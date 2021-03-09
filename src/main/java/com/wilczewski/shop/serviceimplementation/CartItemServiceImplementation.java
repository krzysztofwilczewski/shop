package com.wilczewski.shop.serviceimplementation;

import com.wilczewski.shop.model.CartItem;
import com.wilczewski.shop.repository.CartItemRepository;
import com.wilczewski.shop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImplementation implements CartItemService {

    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImplementation(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void addCartItem(CartItem cartItem){
        cartItemRepository.save(cartItem);
    }
}
