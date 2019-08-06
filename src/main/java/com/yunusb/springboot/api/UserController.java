package com.yunusb.springboot.api;

import com.yunusb.springboot.dto.UserDto;
import com.yunusb.springboot.service.impl.UserServiceImpl;
import com.yunusb.springboot.util.ApiPaths;
import com.yunusb.springboot.util.PaginationMod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.User.BPA)
@Api(value = ApiPaths.User.BPA, description = "Api's Users")
public class UserController {

  private final UserServiceImpl userServiceImpl;

  @Autowired
  public UserController(UserServiceImpl userServiceImpl) {
    this.userServiceImpl = userServiceImpl;
  }

  @GetMapping("/pagination")
  @ApiOperation(value = "Get Users with Pagination", response = UserDto.class)
  public ResponseEntity<PaginationMod<UserDto>> getAllPageable(Pageable pageable){
    PaginationMod<UserDto> userDtoPaginationMod = userServiceImpl.getAllPageable(pageable);
    return ResponseEntity.ok(userDtoPaginationMod);
  }

  @GetMapping
  @ApiOperation(value = "Get Users with getAll method", response = UserDto.class)
  public ResponseEntity<List<UserDto>> getAllUsers(){
    List<UserDto> userDtoList = userServiceImpl.getAll();
    return ResponseEntity.ok(userDtoList);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Users qet by ıd", response = UserDto.class)
  public ResponseEntity<UserDto> getById(@PathVariable(value = "id", required = true) Long id){
    UserDto userDto = userServiceImpl.getById(id);
    return ResponseEntity.ok(userDto);
  }

  @PostMapping
  @ApiOperation(value = "Create User", response = UserDto.class)
  public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto user){
    return ResponseEntity.ok(userServiceImpl.save(user));
  }

}
