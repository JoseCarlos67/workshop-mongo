package com.jcarlos67.workshopmongo.resources;

import com.jcarlos67.workshopmongo.domain.User;
import com.jcarlos67.workshopmongo.dto.UserDTO;
import com.jcarlos67.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> users = service.findAll();
    List<UserDTO> userDTOS = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(userDTOS);
  }
}
