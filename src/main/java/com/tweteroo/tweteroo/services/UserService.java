package com.tweteroo.tweteroo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.repositories.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;

  public void create(User data){
    repository.save(data);
  }

}
