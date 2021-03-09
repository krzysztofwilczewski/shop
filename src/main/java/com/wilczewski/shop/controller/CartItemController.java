package com.wilczewski.shop.controller;

import com.wilczewski.shop.model.Cart;
import com.wilczewski.shop.model.CartItem;
import com.wilczewski.shop.model.Product;
import com.wilczewski.shop.model.User;
import com.wilczewski.shop.service.CartItemService;
import com.wilczewski.shop.service.CartService;
import com.wilczewski.shop.service.ProductService;
import com.wilczewski.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartItemController {

    private CartItemService cartItemService;
    private ProductService productService;
    private CartService cartService;
    private UserService userService;

    @Autowired
    public CartItemController(CartItemService cartItemService, ProductService productService, CartService cartService, UserService userService) {
        this.cartItemService = cartItemService;
        this.productService = productService;
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/add/{productId}")
    public void addProductToCart(@PathVariable Long productId,@AuthenticationPrincipal User active){


        User user = userService.findUserByUserName(active.getUserName());

        Cart cart = user.getCart();

        //Cart cart = new Cart();

        Product product = productService.getProductById(productId);

        List<CartItem> cartItems = cart.getCartItems();

        for(int i=0;i<cartItems.size();i++){

            if (product.getProductId()==cartItems.get(i).getProduct().getProductId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                return ;

            }

        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);

    }

}
