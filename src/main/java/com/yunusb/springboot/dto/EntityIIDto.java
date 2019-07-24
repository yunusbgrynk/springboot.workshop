package com.yunusb.springboot.dto;

import com.yunusb.springboot.model.Options;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "EntityII DTO")
public class EntityIIDto {

  @ApiModelProperty(required = true,value = "ID")
  private Long id;
  @ApiModelProperty(required = true,value = "Description")
  private String description;
  @ApiModelProperty(required = true,value = "Details")
  private String details;
  @ApiModelProperty(required = true,value = "Date")
  private Date date;
  @ApiModelProperty(required = true,value = "Options")
  private Options options;
  @ApiModelProperty(required = true,value = "User of EntityII")
  private UserDto userOfEntityII;
  @ApiModelProperty(required = true,value = "EntityI")
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
