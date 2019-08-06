package com.yunusb.springboot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User DTO")
public class UserDto {

  @ApiModelProperty(required = true,value = "ID")
  private Long id;
  @ApiModelProperty(required = true,value = "First Name")
  private String firstName;
  @ApiModelProperty(required = true,value = "Last Name")
  private String lastName;
  @ApiModelProperty(required = true,value = "Email")
  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
