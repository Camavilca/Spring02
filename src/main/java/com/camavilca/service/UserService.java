package com.camavilca.service;

import com.camavilca.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}