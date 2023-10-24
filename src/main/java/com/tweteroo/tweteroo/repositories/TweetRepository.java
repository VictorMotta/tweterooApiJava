package com.tweteroo.tweteroo.repositories;

import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweteroo.tweteroo.models.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{
  
  @Query("SELECT t FROM Tweet t WHERE t.user.username = :username ORDER BY t.id DESC")
  List<Tweet> findTweetsByUserOrderById(String username);

  @Query("SELECT t FROM Tweet t ORDER BY t.id DESC")
  Page<Tweet> findLastestTweets(Pageable pageable);
  
}
