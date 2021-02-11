package com.wilczewski.shop.repository;

import com.wilczewski.shop.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
}
