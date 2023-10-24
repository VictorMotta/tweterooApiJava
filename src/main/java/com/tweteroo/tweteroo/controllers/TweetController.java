package com.tweteroo.tweteroo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.dtos.TweetResDTO;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.services.TweetService;
import com.tweteroo.tweteroo.services.UserService;

@RestController
@RequestMapping("/api/tweets")
@CrossOrigin(origins = "*")
public class TweetController {
  
  @Autowired
  private TweetService service;


  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<TweetResDTO>> getTweets(@RequestParam(defaultValue = "1") Integer page) {
    Page<Tweet> tweets = service.getAllTweets(page);

    List<TweetResDTO> tweetsRes = tweets.stream()
    .map(tweet -> new TweetResDTO(
      tweet.getUser().getUsername(), 
      tweet.getUser().getAvatar(), 
      tweet.getText()))
    .collect(Collectors.toList());

    return ResponseEntity.status(200).body(tweetsRes);
  }

  @GetMapping("/{username}")
  public ResponseEntity<List<TweetResDTO>> getByUsername(@PathVariable String username) {
    List<Tweet> tweets = service.getByUsername(username);
    
    List<TweetResDTO> tweetsRes = tweets.stream()
    .map(tweet -> new TweetResDTO(
      tweet.getUser().getUsername(), 
      tweet.getUser().getAvatar(), 
      tweet.getText()))
    .collect(Collectors.toList());

    
    return ResponseEntity.status(200).body(tweetsRes);
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public void create(@RequestBody TweetDTO req, @RequestHeader("User") String userHeader) {
    User user = userService.getUserByUsername(userHeader);
    service.create(new Tweet(req.text(), user.getId()));
  }
  

}
