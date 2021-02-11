package com.wilczewski.shop.repository;

import com.wilczewski.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
