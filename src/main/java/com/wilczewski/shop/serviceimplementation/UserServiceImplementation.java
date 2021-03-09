package com.wilczewski.shop.serviceimplementation;

import com.wilczewski.shop.model.User;
import com.wilczewski.shop.repository.UserRepository;
import com.wilczewski.shop.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImplementation(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByUserName(String userName){
        return userRepository.findUserByUserName(userName);
    }

    public void saveUser(User user) {

            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);

    }
}
