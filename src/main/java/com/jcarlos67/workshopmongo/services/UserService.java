package com.jcarlos67.workshopmongo.services;

import com.jcarlos67.workshopmongo.domain.User;
import com.jcarlos67.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }
}
