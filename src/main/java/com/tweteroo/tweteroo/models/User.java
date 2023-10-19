package com.tweteroo.tweteroo.models;

import com.tweteroo.tweteroo.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

  public User(UserDTO req) {
    this.username = req.username();
    this.avatar = req.avatar();
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "username",length = 60, nullable = false, unique = true)
  private String username;

  @Column(name = "avatar",nullable = false)
  private String avatar;
}
