/* package com.yunusb.springboot.api;

import com.yunusb.springboot.security.JwtTokenUtil;
import com.yunusb.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

public class AccountController {


  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final UserServiceImpl userServiceImpl;

  @Autowired
  public AccountController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserServiceImpl userServiceImpl) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.userServiceImpl = userServiceImpl;
  }
}
*/