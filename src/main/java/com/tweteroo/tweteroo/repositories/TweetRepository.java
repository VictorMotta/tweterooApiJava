package com.tweteroo.tweteroo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.tweteroo.models.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{
  
}
