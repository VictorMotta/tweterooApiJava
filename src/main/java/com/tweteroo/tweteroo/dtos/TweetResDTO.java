package com.tweteroo.tweteroo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TweetResDTO (
  @NotBlank
  String username,
  @NotNull
  String avatar,
  @NotNull
  String text
) {
  
}
