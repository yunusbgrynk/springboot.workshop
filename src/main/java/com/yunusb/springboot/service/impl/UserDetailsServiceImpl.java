/* package com.yunusb.springboot.service.impl;

import com.yunusb.springboot.model.User;
import com.yunusb.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    /*
    set index username to avoid loss of performance indexes = {@Index(name = "idx_username", columnList = "username")}
     */
  /*  User user = userRepository.findByUsername(username); // query to database with user
    if(user == null){
      throw new UsernameNotFoundException("Invalid username");
    }

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("USER")));
  }

}
*/