package com.tweteroo.tweteroo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.exceptions.ResourceNotFoundException;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.repositories.TweetRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository repository;

  public Page<Tweet> getAllTweets(Integer page) {
    Pageable pageable = PageRequest.of(page - 1, 5 );
    return repository.findLastestTweets(pageable);
  }

  public List<Tweet> getByUsername(String username) {
    List<Tweet> tweets = repository.findTweetsByUserOrderById(username);

    if (tweets.isEmpty()) {
        throw new ResourceNotFoundException("Not found tweets this username!");
    }

    return tweets;
  }

  public void create(Tweet data) {
    repository.save(data);
  }
  
}
