package com.yunusb.springboot.dto;

import com.yunusb.springboot.model.Options;

import java.util.Date;

public class EntityIIDetailDto {

  private Long id;
  private EntityIIDto entityIIDto;
  private String description;
  private Date date;
  private Options options;
  private String details;
  private UserDto userDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EntityIIDto getEntityIIDto() {
    return entityIIDto;
  }

  public void setEntityIIDto(EntityIIDto entityIIDto) {
    this.entityIIDto = entityIIDto;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Options getOptions() {
    return options;
  }

  public void setOptions(Options options) {
    this.options = options;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public UserDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserDto userDto) {
    this.userDto = userDto;
  }
}
