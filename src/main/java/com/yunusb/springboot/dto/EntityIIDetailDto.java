package com.yunusb.springboot.dto;

import com.yunusb.springboot.model.Options;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "EntityII Details")
public class EntityIIDetailDto {

  @ApiModelProperty(required = true,value = "ID")
  private Long id;
  @ApiModelProperty(required = true,value = "EntityII")
  private EntityIDto entityIDto;
  @ApiModelProperty(required = true,value = "Description")
  private String description;
  @ApiModelProperty(required = true,value = "Date")
  private Date date;
  @ApiModelProperty(required = true,value = "Options")
  private Options options;
  @ApiModelProperty(required = true,value = "Details of EntityII")
  private String details;
  @ApiModelProperty(required = true,value = "User EntityII")
  private UserDto userDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EntityIDto getEntityIDto() {
    return entityIDto;
  }

  public void setEntityIDto(EntityIDto entityIDto) {
    this.entityIDto = entityIDto;
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
