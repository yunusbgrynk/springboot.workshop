package com.yunusb.springboot.model;


import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Audited
public abstract class BaseEntity extends AbstractEntity {

  @CreatedDate
  private Date createdAt;
  @CreatedBy
  private String createdBy;
  @LastModifiedDate
  private Date updatedAt;
  @LastModifiedBy
  private String updeatedBy;
  private boolean status;

  @Basic
  @Column(name = "created_at" , updatable = false)
  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Basic
  @Column(name = "created_by" , length = 50 , updatable = false)
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  @Basic
  @Column(name = "updated_at" , insertable = false)
  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Basic
  @Column(name = "updated_by" , length = 50 , insertable = false)
  public String getUpdeatedBy() {
    return updeatedBy;
  }

  public void setUpdeatedBy(String updeatedBy) {
    this.updeatedBy = updeatedBy;
  }

  @Basic
  @Column(name = "status")
  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

}
