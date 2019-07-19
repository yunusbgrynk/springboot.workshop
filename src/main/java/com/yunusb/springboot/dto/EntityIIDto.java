package com.yunusb.springboot.dto;

import com.yunusb.springboot.model.Options;

import java.util.Date;

public class EntityIIDto {

  private Long id;
  private String description;
  private String details;
  private Date date;
  private Options options;
  private UserDto userOfEntityII;
  private EntityIDto entityIDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
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

  public UserDto getUserOfEntityII() {
    return userOfEntityII;
  }

  public void setUserOfEntityII(UserDto userOfEntityII) {
    this.userOfEntityII = userOfEntityII;
  }

  public EntityIDto getEntityIDto() {
    return entityIDto;
  }

  public void setEntityIDto(EntityIDto entityIDto) {
    this.entityIDto = entityIDto;
  }
}
