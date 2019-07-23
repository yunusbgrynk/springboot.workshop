package com.yunusb.springboot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EntityI Data Transfer Object")
public class EntityIDto {

  @ApiModelProperty(value = "EntityI ID")
  private Long id;

  @ApiModelProperty(value = "EntityI Name")
  private String ent1name;

  @ApiModelProperty(value = "EntityI Code")
  private String ent1code;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEnt1name() {
    return ent1name;
  }

  public void setEnt1name(String ent1name) {
    this.ent1name = ent1name;
  }

  public String getEnt1code() {
    return ent1code;
  }

  public void setEnt1code(String ent1code) {
    this.ent1code = ent1code;
  }

}
