package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.services.TweetService;
import com.tweteroo.tweteroo.services.UserService;

@RestController
@RequestMapping("/tweets")
public class TweetController {
  
  @Autowired
  private TweetService service;


  @Autowired
  private UserService userService;


  @PostMapping
  public void create(@RequestBody TweetDTO req) {
    User user = userService.getUserByUsername(req.username());
    service.create(new Tweet(req.text(), user.getId()));
  }

}
