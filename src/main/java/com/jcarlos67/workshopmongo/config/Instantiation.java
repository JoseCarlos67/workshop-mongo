package com.jcarlos67.workshopmongo.config;

import com.jcarlos67.workshopmongo.domain.User;
import com.jcarlos67.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    userRepository.deleteAll();

    User maria = new User("Maria Brown", "maria@gmail.com");
    User alex = new User("Alex Green", "alex@gmail.com");
    User bob = new User("Bob Grey", "bob@gmail.com");

    userRepository.saveAll(Arrays.asList(maria, alex, bob));
  }
}
