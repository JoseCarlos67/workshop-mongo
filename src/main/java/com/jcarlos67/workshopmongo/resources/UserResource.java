package com.jcarlos67.workshopmongo.resources;

import com.jcarlos67.workshopmongo.domain.User;
import com.jcarlos67.workshopmongo.dto.UserDTO;
import com.jcarlos67.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User obj = service.findById(id);
    return ResponseEntity.ok().body(new UserDTO(obj));
  }

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
    User obj = service.fromDTO(objDto);
    obj = service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable String id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
    User obj = service.fromDTO(objDto);
    obj.setId(id);
    obj = service.update(obj);
    return ResponseEntity.noContent().build();
  }

}
