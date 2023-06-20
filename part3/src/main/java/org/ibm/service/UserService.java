package org.ibm.service;

import org.ibm.model.User;
import org.ibm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired UserRepository userRepository;

  public void addUser(User user){
    userRepository.saveAndFlush(user);
  }

}
