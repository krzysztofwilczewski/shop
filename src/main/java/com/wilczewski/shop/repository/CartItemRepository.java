package com.wilczewski.shop.repository;

import com.wilczewski.shop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
