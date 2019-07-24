package com.yunusb.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

public class AccountController {

  @Autowired
  private AuthenticationManager authenticationManager;

  

}
