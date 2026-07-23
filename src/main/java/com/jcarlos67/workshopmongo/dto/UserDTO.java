package com.jcarlos67.workshopmongo.dto;

import com.jcarlos67.workshopmongo.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  @Setter(AccessLevel.NONE)
  private String id;

  private String name;
  private String email;

  public UserDTO() {
  }

  public UserDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
  }
}
