package com.yunusb.springboot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User DTO")
public class UserDto {

  @ApiModelProperty(required = true,value = "ID")
  private Long id;
  @ApiModelProperty(required = true,value = "Name Surname")
  private String nameSurname;
  @ApiModelProperty(required = true,value = "Email")
  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNameSurname() {
    return nameSurname;
  }

  public void setNameSurname(String nameSurname) {
    this.nameSurname = nameSurname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
