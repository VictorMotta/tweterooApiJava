package com.tweteroo.tweteroo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.repositories.TweetRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository repository;


  public void create(Tweet data) {
    repository.save(data);
  }
  
}
