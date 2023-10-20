package com.tweteroo.tweteroo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TweetDTO(
  @NotNull
  String text, 
  @NotBlank
  String username) {
}
