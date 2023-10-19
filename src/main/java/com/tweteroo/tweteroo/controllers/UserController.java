package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.UserDTO;
import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public void signUp(@RequestBody UserDTO req){
    userService.create(new User(req));
  }
}
