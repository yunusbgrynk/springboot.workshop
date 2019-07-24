package com.yunusb.springboot.service;

import com.yunusb.springboot.dto.UserDto;
import com.yunusb.springboot.util.PaginationMod;
import org.springframework.data.domain.Pageable;

public interface UserService {

  UserDto save(UserDto userDto);
  UserDto getById(Long id);
  PaginationMod<UserDto> getAllPageable(Pageable pageable);
  UserDto getByUsername(String username);


}
