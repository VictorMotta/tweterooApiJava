package com.tweteroo.tweteroo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.repositories.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;

  public List<User> getAllUsers(){
    return repository.findAll();
  }

  public Optional<User> getUserById(Integer userId) {
    return repository.findById(userId);
  }

  public void create(User data){
    User user = getUserByUsername(data.getUsername());
    System.out.println(user);
    if(user != null) {
      user.setAvatar(data.getAvatar());
      repository.save(user);
    }else {
    repository.save(data);
    }
  }

  public User getUserByUsername(String username) {
    return repository.findByUsername(username);
  }

}
