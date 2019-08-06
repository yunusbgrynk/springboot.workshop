package com.yunusb.springboot.service.impl;

import com.yunusb.springboot.dto.UserDto;
import com.yunusb.springboot.model.User;
import com.yunusb.springboot.repository.UserRepository;
import com.yunusb.springboot.service.UserService;
import com.yunusb.springboot.util.PaginationMod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;
 // private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
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
    User user = userRepository.getOne(id);
    return modelMapper.map(user, UserDto.class);
  }

  @Override
  public PaginationMod<UserDto> getAllPageable(Pageable pageable) {
    Page<User> userPage = userRepository.findAll(pageable);
    PaginationMod<UserDto> paginationMod = new PaginationMod<UserDto>();
    UserDto[] userDtos = modelMapper.map(userPage.getContent(), UserDto[].class);
    paginationMod.setValue(userPage, Arrays.asList(userDtos));
    return paginationMod;
  }

  @Override
  public UserDto getByUsername(String username) {
    User user = userRepository.findByUsername(username);
    return modelMapper.map(user, UserDto.class);
  }

  public List<UserDto> getAll(){
    List<User> userList = userRepository.findAll();
    return Arrays.asList(modelMapper.map(userList, UserDto[].class));
  }
}
