package com.tweteroo.tweteroo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
  @NotBlank
  @Size(min = 5, max = 60)
  String username,
  @NotBlank
  String avatar
) {
  
}
