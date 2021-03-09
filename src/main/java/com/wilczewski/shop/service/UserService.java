package com.wilczewski.shop.service;

import com.wilczewski.shop.model.User;

public interface UserService {

  User findUserByUserName(String userName);

  //  public void saveUser(User user);
}
