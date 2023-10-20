package com.tweteroo.tweteroo.services;

import java.util.List;

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

  public void create(User data){
    repository.save(data);
  }

}
