package com.yunusb.springboot.service.impl;

import com.yunusb.springboot.dto.UserDto;
import com.yunusb.springboot.model.User;
import com.yunusb.springboot.repository.UserRepository;
import com.yunusb.springboot.service.UserService;
import com.yunusb.springboot.util.PaginationMod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public UserDto save(UserDto userDto) {
    User user = modelMapper.map(userDto, User.class);
    user = userRepository.save(user);
    userDto.setId(user.getId());
    return userDto;
  }

  @Override
  public UserDto getById(Long id) {

    return null;
  }

  @Override
  public PaginationMod<UserDto> getAllPageable(Pageable pageable) {
    return null;
  }

  @Override
  public UserDto getByUsername(String username) {
    return null;
  }
}
